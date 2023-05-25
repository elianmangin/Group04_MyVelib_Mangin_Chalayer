package Group04_MyVelib_Mangin_Chalayer.system.core;

import java.time.temporal.ChronoUnit;

public class UserBalance {
	protected int numberOfRide;
	protected int totalTime;
	protected double totalCharges;
	protected int totalTimeCredit;

	public UserBalance() {
		super();
		this.numberOfRide = 0;
		this.totalTime = 0;
		this.totalCharges = 0;
		this.totalTimeCredit = 0;
	}

	public void addRide(Ride ride) {
		numberOfRide++;
		double duration = ChronoUnit.MINUTES.between(ride.getStartTime(), ride.getEndTime());
		totalTime += duration;
		totalCharges+=ride.cost;
	}

	public void addTotalTimeCredit(int addedTotalTimeCredit) throws GeneralException{
		if (addedTotalTimeCredit<0) throw new GeneralException();
		totalTimeCredit+=addedTotalTimeCredit;
	}


	// Getters, Setters, toString
	public int getNumberOfRide() {
		return numberOfRide;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public double getTotalCharges() {
		return totalCharges;
	}

	public int getTotalTimeCredit() {
		return totalTimeCredit;
	}

	@Override
	public String toString() {
		return "Balance : \nRides : " + numberOfRide + "           | Time on bike : " + totalTime + " \nTotal charges : "
				+ totalCharges + " | Time credit : " + totalTimeCredit + ".";
	}










}
