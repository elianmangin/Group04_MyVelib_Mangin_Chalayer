package myVelibProject;

import java.time.LocalTime;

public class RideStart {
	protected User user;
	protected Coordinates startingCoordinates;
	protected LocalTime startTime;
	protected DockingStation startingDockingStation;
	protected Bicycle bicycleUsed;
	
	
	public RideStart(User user, Coordinates startingCoordinates, LocalTime startTime,
			DockingStation startingDockingStation, Bicycle bicycleUsed) {
		super();
		this.user = user;
		this.startingCoordinates = startingCoordinates;
		this.startTime = startTime;
		this.startingDockingStation = startingDockingStation;
		this.bicycleUsed = bicycleUsed;
	}
	@Override
	public String toString() {
		return "RideStart [user=" + user + ", startingCoordinates=" + startingCoordinates + ", startTime=" + startTime
				+ ", startingDockingStation=" + startingDockingStation + ", bicycleUsed=" + bicycleUsed + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Coordinates getStartingCoordinates() {
		return startingCoordinates;
	}
	public void setStartingCoordinates(Coordinates startingCoordinates) {
		this.startingCoordinates = startingCoordinates;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public DockingStation getStartingDockingStation() {
		return startingDockingStation;
	}
	public void setStartingDockingStation(DockingStation startingDockingStation) {
		this.startingDockingStation = startingDockingStation;
	}
	public Bicycle getBicycleUsed() {
		return bicycleUsed;
	}
	public void setBicycleUsed(Bicycle bicycleUsed) {
		this.bicycleUsed = bicycleUsed;
	}

}
