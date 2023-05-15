package myVelibProject;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Ride {
	protected User user;
	protected Coordinates startingCoordinates;//pour initialiser LocalTime time = LocalTime.of(5,15) pour 5h15;
	protected Coordinates endingCoordinates;
	protected LocalTime startTime;
	protected LocalTime endTime;
	protected DockingStation startingDockingStation;
	protected DockingStation endingDockingStation;
	protected Bicycle bicycleUsed;
	protected double cost;
	
	
	
	public Ride(User user, Coordinates startingCoordinates, Coordinates endingCoordinates, LocalTime startTime,
			LocalTime endTime, DockingStation startingDockingStation, DockingStation endingDockingStation,
			Bicycle bicycleUsed) {
		super();
		this.user = user;
		this.startingCoordinates = startingCoordinates;
		this.endingCoordinates = endingCoordinates;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startingDockingStation = startingDockingStation;
		this.endingDockingStation = endingDockingStation;
		this.bicycleUsed = bicycleUsed;
		cost = costComputing(user,bicycleUsed,startTime,endTime,startingDockingStation,endingDockingStation);
	}


	//Créer une exception au lieu de return 0 à la fin
	protected double costComputing(User user, Bicycle bicycleUsed,LocalTime startTime,LocalTime endTime,DockingStation startingDockingStation,DockingStation endingDockingStation) {
		double cost = 0;
		double timeCredit = user.getTimeCredit();
		double duration = ChronoUnit.MINUTES.between(startTime, endTime);
		if(user.getRegistrationCard() == "vLibre") {
			duration = duration-60;
			if(duration <0) {return 0;}
			if(timeCredit>duration) {
				user.setTimeCredit((int)timeCredit-(int)duration);
				return 0;
			}
			if(timeCredit <= duration) {
				user.setTimeCredit(0);
				duration = duration-timeCredit;
				if (bicycleUsed.getType()=="mecanical") { cost = duration/60;}
				if (bicycleUsed.getType()=="electrical") {cost = 1+2*duration/60;}
			}
		if(user.getRegistrationCard() == null) {
			if (bicycleUsed.getType()=="mecanical") {cost = duration/60;}
			if (bicycleUsed.getType()=="electrical") {cost = 2*duration/60;}
		}
		
		if(user.getRegistrationCard() == "vMax") {
			duration = duration-60;
			if(duration <0) {return 0;}
			else {cost = duration/60;}
		}
		}
		if(startingDockingStation == null && endingDockingStation !=null) {return 0.9*cost;}
		if(startingDockingStation != null && endingDockingStation ==null) {return 1.1*cost;}
		else {return cost;}
	}

	
	@Override
	public String toString() {
		return "Ride [user=" + user + ", startingCoordinates=" + startingCoordinates + ", endingCoordinates="
				+ endingCoordinates + ", startTime=" + startTime + ", endTime=" + endTime + ", startingDockingStation="
				+ startingDockingStation + ", endingDockingStation=" + endingDockingStation + ", bicycleUsed="
				+ bicycleUsed + ", cost=" + cost + "]";
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
	public Coordinates getEndingCoordinates() {
		return endingCoordinates;
	}
	public void setEndingCoordinates(Coordinates endingCoordinates) {
		this.endingCoordinates = endingCoordinates;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
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
	public Bicycle getBicycleUsed() {
		return bicycleUsed;
	}
	public void setBicycleUsed(Bicycle bicycleUsed) {
		this.bicycleUsed = bicycleUsed;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

}
