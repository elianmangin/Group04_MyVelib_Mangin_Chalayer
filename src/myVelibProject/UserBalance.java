package myVelibProject;

import java.time.temporal.ChronoUnit;

public class UserBalance {
	protected int numberOfRide;
	protected int totalTime;
	protected double totalCharges;
	protected int totalTimeCredit;
	
	public void addRide(Ride ride) {
		numberOfRide++;
		double duration = ChronoUnit.MINUTES.between(ride.getStartTime(), ride.getEndTime());
		totalTime += duration;
		totalCharges+=ride.cost;
	}
	public void addTotalTimeCredit(int addedTotalTimeCredit) {
		totalTimeCredit+=addedTotalTimeCredit;
	}
	public UserBalance() {
		super();
		numberOfRide = 0;
		totalTime = 0;
		totalCharges = 0;
		totalTimeCredit = 0;	
	}


	public int getTotalTimeCredit() {
		return totalTimeCredit;
	}


	public void setTotalTimeCredit(int timeCredit) {
		this.totalTimeCredit = timeCredit;
	}


	@Override
	public String toString() {
		return "userBalance [numberOfRide=" + numberOfRide + ", totalTime=" + totalTime + ", totalCharges="
				+ totalCharges + ", timeCredit=" + totalTimeCredit + "]";
	}
}
