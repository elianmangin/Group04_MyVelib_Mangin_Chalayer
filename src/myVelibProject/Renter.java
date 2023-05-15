package myVelibProject;

import java.time.LocalTime;

public class Renter {
	protected MyVelib myVelib;
	
	public Renter(MyVelib myVelib) {
		super();
		this.myVelib = myVelib;
	}


	public void rentBicycle(User user, Coordinates startingCoordinates, LocalTime startTime,
			DockingStation startingDockingStation,ParkingSlot startingParkingSlot, Bicycle bicycleUsed) {
		if (user.currentlyRenting==true || bicycleUsed.isCurrentlyRentedBicycle()==true ) {
			System.out.print("throw exception");
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
			DockingStation endingDockingStation,ParkingSlot endingParkingSlot, Bicycle bicycleUsed) {
		if (user.currentlyRenting==false || bicycleUsed.isCurrentlyRentedBicycle()==false ) {
			System.out.print("throw exception");
		}
		user.setCurrentlyRenting(false);
		bicycleUsed.setCurrentlyRentedBicycle(false);
		if(endingDockingStation != null) {
			endingDockingStation.dockingStationBalance.addreturn();	
		}
		if (endingParkingSlot != null) {endingParkingSlot.addBicycle(bicycleUsed,endingDockingStation);}
		Ride ride = new Ride(user,user.ridestart.startingCoordinates,endingCoordinates,user.ridestart.startTime,endTime,user.ridestart.startingDockingStation,endingDockingStation,bicycleUsed);
		if (endingDockingStation.getType() == "plus" && user.registrationCard !=null){user.addTimeCredit(5);}
		System.out.print("\n" + user.getName() +" has to be billed "+ride.cost);
		user.balance.addRide(ride);
		myVelib.addRide(ride);
		
	}
	
}
