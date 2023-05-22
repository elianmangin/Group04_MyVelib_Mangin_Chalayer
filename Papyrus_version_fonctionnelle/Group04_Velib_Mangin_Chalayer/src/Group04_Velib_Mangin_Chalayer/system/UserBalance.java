package Group04_Velib_Mangin_Chalayer.system;

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
	
	public void addTotalTimeCredit(int addedTotalTimeCredit) {
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
		return "Balance : \nNumber of ride : " + numberOfRide + " / Time on bike : " + totalTime + " / Total charges :"
				+ totalCharges + " / Time credit : " + totalTimeCredit + ".";
	}
	
	





	
	
	
}
