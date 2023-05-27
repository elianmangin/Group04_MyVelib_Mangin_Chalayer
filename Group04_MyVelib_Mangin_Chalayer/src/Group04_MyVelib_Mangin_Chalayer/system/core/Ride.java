package Group04_MyVelib_Mangin_Chalayer.system.core;

import java.time.LocalTime;

/**
 * This class store the information of a current ride used to compute the cost and to store the bicycle while it's not in a station.
 * <p>
 * It is related to a user, a starting location (and an ending one), a strat time (and an ending one), the bicycle used.
 * </p>
 */
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
	
	/** Initialize the ride with the departure values (bicycle taken in the street).*/
	public Ride(User user, Bicycle bicycleUsed, LocalTime startTime) {
		super();
		this.user = user;
		this.startCoordinates = bicycleUsed.getGps();
		this.startTime = startTime;
		this.startStation = null;
		this.bicycleUsed = bicycleUsed;
	}
	
	/** Initialize the ride with the departure values (bicycle taken in a station).*/
	public Ride(User user, DockingStation startStation, Bicycle bicycleUsed, LocalTime startTime) {
		super();
		this.user = user;
		this.startCoordinates = startStation.getGps();
		this.startTime = startTime;
		this.startStation = startStation;
		this.bicycleUsed = bicycleUsed;
	}

	/** Add the arrival values (bicycle returned in the street).*/
	public void endRide(DockingStation endStation, LocalTime endTime) throws GeneralException  {
		if(!endTime.isAfter(startTime)) throw new GeneralException();
		this.endCoordinates = endStation.getGps();
		this.endTime = endTime;
		this.endStation = endStation;
		this.bicycleUsed.setGps(endCoordinates);
	}
	
	/** Add the departure values (bicycle returned to a station).*/
	public void endRide(Coordinates gps, LocalTime endTime) throws GeneralException {
		if(!endTime.isAfter(startTime)) throw new GeneralException();
		this.endCoordinates = gps;
		this.endTime = endTime;
		this.endStation = null;
		this.bicycleUsed.setGps(endCoordinates);
	}


	// Getters, Setters, toString
	@Override
	public String toString() {
		return "Ride from " +startStation+ "(" + startCoordinates + ") to "+endStation+ "(" + endCoordinates
				+"\nDeparture : " + startTime + " / Arrival : " + endTime + "\nCost : " + cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
