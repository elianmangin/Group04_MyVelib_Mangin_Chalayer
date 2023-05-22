package Group04_Velib_Mangin_Chalayer.system;

import java.time.LocalTime;

public class Renter {
	private MyVelib myVelib;
	private User user;
	@SuppressWarnings("rawtypes")
	private RideItinerary itinerary;

	public Renter(MyVelib myVelib) {
		super();
		this.myVelib = myVelib;
		this.user = null;
		this.itinerary = null;

	}
	
	public void connectUser(User U) {
		this.user = U;
	}

	public void disconnectUser() {
		this.user = null;
		this.itinerary = null;
	}


	public void askPlanning(Coordinates destination, String bicycleType, String planningType) {
		if (this.user != null) {
			PlanningFactory PF = new PlanningFactory();
			RidePlanning RP = PF.create(planningType, myVelib);
			itinerary = RP.plan(user.getGps(),destination, bicycleType);
		}
		else {
			System.out.println("Warning : No user connected");
		}

	}

	public void rentBicycle(LocalTime startTime) throws GeneralException {
		// If the bicycle is taken from a Docking Station
		if (itinerary.start instanceof DockingStation) {
			DockingStation startStation = (DockingStation) this.itinerary.start;

			// Take the bike from the station and update its number of rent
			Bicycle bicycle = startStation.takeBicycle(this.itinerary.getType());
			bicycle.setCurrentlyRentedBicycle(true);
			startStation.dockingStationBalance.totalNumberOfRent++;

			// Change bike status and store start data of the user current ride 
			bicycle.setCurrentlyRentedBicycle(true);
			user.setCurrentRide(new Ride(this.user, startStation, bicycle, startTime));
		}

		// If the bicycle is taken from the street
		else if (itinerary.start instanceof Bicycle) {

			Bicycle bicycle = (Bicycle) this.itinerary.start;
			bicycle.setCurrentlyRentedBicycle(true);

			bicycle.setCurrentlyRentedBicycle(true);
			user.setCurrentRide(new Ride(this.user, bicycle, startTime));
		}

	}

	public void returnBicycle(LocalTime endTime) throws GeneralException {
		// If the bicycle is returned to a Docking Station
		if (itinerary.getEnd() instanceof DockingStation) {
			DockingStation endStation = (DockingStation) this.itinerary.end;

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
				user.registrationCard.addCredit(5);;
				user.balance.addTotalTimeCredit(5);
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




