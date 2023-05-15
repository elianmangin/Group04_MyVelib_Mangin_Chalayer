package myVelibProject;

public class UserBalance {
	protected int numberOfRide;
	protected int totalTime;
	protected double totalCharges;
	protected int timeCredit;
	
	public void addRide(Ride ride) {
		
	}
	public UserBalance() {
		super();
		numberOfRide = 0;
		totalTime = 0;
		totalCharges = 0;
		timeCredit = 0;	
	}


	public int getTimeCredit() {
		return timeCredit;
	}


	public void setTimeCredit(int timeCredit) {
		this.timeCredit = timeCredit;
	}


	@Override
	public String toString() {
		return "userBalance [numberOfRide=" + numberOfRide + ", totalTime=" + totalTime + ", totalCharges="
				+ totalCharges + ", timeCredit=" + timeCredit + "]";
	}
}
