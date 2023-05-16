package myVelibProject;

public class RideItinerary {
	protected DockingStation startingDockingStation;
	protected DockingStation endingDockingStation;
	
	public RideItinerary(DockingStation startingDockingStation, DockingStation endingDockingStation) {
		super();
		this.startingDockingStation = startingDockingStation;
		this.endingDockingStation = endingDockingStation;
	}
	@Override
	public String toString() {
		return "RideItinerary [startingDockingStation=" + startingDockingStation + ", endingDockingStation="
				+ endingDockingStation + "]";
	}
	public DockingStation getStartingDockingStation() {
		return startingDockingStation;
	}
	public void setStartingDockingStation(DockingStation startingDockingStation) {
		this.startingDockingStation = startingDockingStation;
	}
	public DockingStation getEndingDockingStation() {
		return endingDockingStation;
	}
	public void setEndingDockingStation(DockingStation endingDockingStation) {
		this.endingDockingStation = endingDockingStation;
	}

}
