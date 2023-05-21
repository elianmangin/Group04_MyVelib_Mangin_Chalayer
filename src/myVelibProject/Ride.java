package myVelibProject;

import java.time.LocalTime;

public class Ride {
	protected User user;
	protected Coordinates startCoordinates;//pour initialiser LocalTime time = LocalTime.of(5,15) pour 5h15;
	protected Coordinates endCoordinates;
	protected LocalTime startTime;
	protected LocalTime endTime;
	protected DockingStation startStation;
	protected DockingStation endStation;
	protected Bicycle bicycleUsed;
	protected double cost;

	public Ride(User user, Bicycle bicycleUsed, LocalTime startTime) {
		super();
		this.user = user;
		this.startCoordinates = bicycleUsed.getGps();
		this.startTime = startTime;
		this.startStation = null;
		this.bicycleUsed = bicycleUsed;
	}

	public Ride(User user, DockingStation startStation, Bicycle bicycleUsed, LocalTime startTime) {
		super();
		this.user = user;
		this.startCoordinates = startStation.getGps();
		this.startTime = startTime;
		this.startStation = startStation;
		this.bicycleUsed = bicycleUsed;
	}


	public void endRide(DockingStation endStation, LocalTime endTime) {
		this.endCoordinates = endStation.getGps();
		this.endTime = endTime;
		this.endStation = endStation;
	}
	
	public void endRide(Coordinates gps, LocalTime endTime) {
		this.endCoordinates = gps;
		this.endTime = endTime;
		this.endStation = null;
	}

	
	// Getters, Setters, toString
	@Override
	public String toString() {
		return "Ride from " +startStation+ "(" + startCoordinates + ") to "+endStation+ "(" + endCoordinates
				+"\nDeparture : " + startTime + " / Arrival : " + endTime + "\nCost : " + cost;
	}

	public Coordinates getStartCoordinates() {
		return startCoordinates;
	}

	public Coordinates getEndCoordinates() {
		return endCoordinates;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public DockingStation getStartStation() {
		return startStation;
	}

	public DockingStation getEndStation() {
		return endStation;
	}

	public Bicycle getBicycleUsed() {
		return bicycleUsed;
	}

	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	

}
