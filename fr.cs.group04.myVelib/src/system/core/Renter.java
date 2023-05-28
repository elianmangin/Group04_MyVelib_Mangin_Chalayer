package system.core;

import java.time.LocalTime;

/**
 * Used to compute the rent, return, and ask  planning.
 * <p>
 * The renter is linked to the myVelib system and allows users to connect to it and disconnect.
 * </p>
 */
public class Renter {
	private MyVelib myVelib;
	private User user;
	@SuppressWarnings("rawtypes")
	private RideItinerary itinerary;
	
	/** Creates a renter and link it to a given myVelib system.*/
	public Renter(MyVelib myVelib) {
		super();
		this.myVelib = myVelib;
		this.user = null;
		this.itinerary = null;

	}
	
	/** Connect a user to the renter.*/
	public void connectUser(User U) throws GeneralException {
		if(user != null) throw new GeneralException("User : "+user.getName() +" is already connected");
		this.user = U;
	}
	
	/** Disconnect the user from the renter.*/
	public void disconnectUser() {
		this.user = null;
		this.itinerary = null;
	}

	/** Ask for the itinerary to go to a given destination (x,y) using a bicycle of a given type following 	a given planning.
	 * @see RidePlanning*/
	public void askPlanning(Coordinates destination, String bicycleType, String planningType) throws GeneralException {
		if (this.user  == null) throw new GeneralException("User not connected");
		PlanningFactory PF = new PlanningFactory();
		RidePlanning RP = PF.create(planningType, myVelib);
		itinerary = RP.plan(user.getGps(),destination, bicycleType);

	}
	
	/** Rent a bicycle a the start of the RideItinerary.*/
	public int rentBicycle(LocalTime startTime) throws GeneralException {
		if (this.user  == null) throw new GeneralException("User not connected");
		// If the bicycle is taken from a Docking Station
		if (itinerary.start instanceof DockingStation) {
			DockingStation startStation = (DockingStation) this.itinerary.start;
			if (startStation.getStatus().equals("offline")) {
				this.disconnectUser();
				throw new GeneralException("This station is offline for the moment");
			}

			// Take the bike from the station and update its number of rent
			Bicycle bicycle = startStation.takeBicycle(this.itinerary.getType());
			startStation.dockingStationBalance.totalNumberOfRent++;
			
			if ((double)startStation.getNumberOfSlotsOccupied() < 0.4*((double)startStation.getNumberOfSlots())) {
				startStation.setType("plus");
			}

			// Change bike status and store start data of the user current ride
			bicycle.setCurrentlyRentedBicycle(true);
			user.setCurrentRide(new Ride(this.user, startStation, bicycle, startTime));

			return bicycle.getUniqID();
		}

		// If the bicycle is taken from the street
		else if (itinerary.start instanceof Bicycle) {

			Bicycle bicycle = (Bicycle) this.itinerary.start;
			if (bicycle.getInStation()) {throw new GeneralException("This bicycle is in a station and cannot be rented directly");}

			bicycle.setCurrentlyRentedBicycle(true);
			user.setCurrentRide(new Ride(this.user, bicycle, startTime));
			return bicycle.getUniqID();
		}
		throw new GeneralException("Fail to rent a bike");

	}
	
	/** Return a bicycle to the end of the RideItinerary.*/
	public void returnBicycle(LocalTime endTime) throws GeneralException {
		if (this.user  == null) throw new GeneralException("User not connected");
		// If the bicycle is returned to a Docking Station
		if (itinerary.getEnd() instanceof DockingStation) {
			DockingStation endStation = (DockingStation) this.itinerary.end;
			if (endStation.getStatus().equals("offline")) {
				this.disconnectUser();
				throw new GeneralException("This station is offline for the moment");
			}

			// Update user and bike location
			user.setGps(endStation.getGps());
			user.currentRide.bicycleUsed.setGps(endStation.getGps());
			user.currentRide.bicycleUsed.setCurrentlyRentedBicycle(false);

			// Put the bike in the station and update the number of return
			endStation.addBicycle(user.getCurrentRide().bicycleUsed);
			endStation.dockingStationBalance.totalNumberOfReturn++;

			// Add the end values of the ride to user.currentRide
			user.currentRide.endRide(endStation, endTime);

			// Compute the cost of the ride and charge the user
			double cost = user.registrationCard.strategy.calculate(this.user.currentRide);
			user.charge(cost);

			// Add time credit if this is a "plus" station
			if (endStation.getType() == "plus" && this.user.registrationCard.getType() !=null){
				user.registrationCard.addCredit(5);
				user.balance.addTotalTimeCredit(5);
			}
			
			if ((double)endStation.getNumberOfSlotsOccupied() > 0.4*((double)endStation.getNumberOfSlots())) {
				endStation.setType(null);
			}

			// Add the cost value to the current ride and update user balance
			user.currentRide.setCost(cost);
			user.balance.addRide(user.currentRide);

			// End the process
			user.setCurrentRide(null);
			this.disconnectUser();

		}

		// If the bicycle is returned to the street
		else if (itinerary.getEnd() instanceof Coordinates) {
			Coordinates endGps = (Coordinates) this.itinerary.end;

			// Update user and bike location
			user.setGps(endGps);
			user.currentRide.bicycleUsed.setGps(endGps);
			user.currentRide.bicycleUsed.setCurrentlyRentedBicycle(false);

			// Add the end values of the ride to user.currentRide
			user.currentRide.endRide(endGps, endTime);

			// Compute the cost of the ride and charge the user
			double cost = user.registrationCard.strategy.calculate(this.user.currentRide);
			user.charge(cost);

			// Add the cost value to the current ride and update user balance
			user.currentRide.setCost(cost);
			user.balance.addRide(user.currentRide);

			// End the process
			user.setCurrentRide(null);
			this.disconnectUser();

		}

	}



	// Getters, Setters, toString
	public MyVelib getMyVelib() {
		return myVelib;
	}

	public User getUser() {
		return user;
	}

	@SuppressWarnings("rawtypes")
	public RideItinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(@SuppressWarnings("rawtypes") RideItinerary itinerary) {
		this.itinerary = itinerary;
	}



	/*
	public void rentBicycle(User user, Coordinates startingCoordinates, LocalTime startTime,
			DockingStation startingDockingStation,ParkingSlot startingParkingSlot, Bicycle bicycleUsed) {
		if (user.currentlyRenting==true || bicycleUsed.isCurrentlyRentedBicycle()==true ) {
			System.out.print("throw exception rent");
		}
		user.setCurrentlyRenting(true);
		bicycleUsed.setCurrentlyRentedBicycle(true);
		if(startingDockingStation != null) {
			startingDockingStation.dockingStationBalance.addrent();
		}
		if (startingParkingSlot != null) {startingParkingSlot.removeBicycle(startingDockingStation);}
		user.ridestart = new RideStart(user, startingCoordinates, startTime, startingDockingStation, bicycleUsed);
	}


	public void returnBicycle(User user, Coordinates endingCoordinates, LocalTime endTime,
			DockingStation endingDockingStation,ParkingSlot endingParkingSlot, Bicycle bicycleUsed) throws GeneralException {
		if (user.currentlyRenting==false || bicycleUsed.isCurrentlyRentedBicycle()==false ) {
			System.out.print("throw exception return");
		}
		user.setCurrentlyRenting(false);
		bicycleUsed.setCurrentlyRentedBicycle(false);
		if(endingDockingStation != null) {
			endingDockingStation.dockingStationBalance.addreturn();
		}
		if (endingParkingSlot != null) {endingParkingSlot.addBicycle(bicycleUsed,endingDockingStation);}
		Ride ride = new Ride(user,user.ridestart.startCoordinates,endingCoordinates,user.ridestart.startTime,endTime,user.ridestart.startStation,endingDockingStation,bicycleUsed);
		if (endingDockingStation.getType() == "plus" && user.registrationCard !=null){
			user.addTimeCredit(5);
			user.balance.addTotalTimeCredit(5);
		}
		user.getCreditCard().charge(ride.cost);
		user.balance.addRide(ride);
		myVelib.addRide(ride);*/

}




