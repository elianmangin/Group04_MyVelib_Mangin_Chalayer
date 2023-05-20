package myVelibProject;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Ride {
	protected Coordinates startCoordinates;//pour initialiser LocalTime time = LocalTime.of(5,15) pour 5h15;
	protected Coordinates endCoordinates;
	protected LocalTime startTime;
	protected LocalTime endTime;
	protected DockingStation startStation;
	protected DockingStation endStation;
	protected Bicycle bicycleUsed;
	protected double cost;

	public Ride(Bicycle bicycleUsed, LocalTime startTime) {
		super();
		this.startCoordinates = bicycleUsed.getGps();
		this.startTime = startTime;
		this.startStation = null;
		this.bicycleUsed = bicycleUsed;
	}

	public Ride(DockingStation startStation, Bicycle bicycleUsed, LocalTime startTime) {
		super();
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
	
	

	


	

	//Créer une exception au lieu de return 0 à la fin
	/*
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
		if(startingDockingStation == null && endingDockingStation !=null) {return 0.9*cost;}
		if(startingDockingStation != null && endingDockingStation ==null) {return 1.1*cost;}
		else {return cost;}
	}*/


}
