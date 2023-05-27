package Group04_MyVelib_Mangin_Chalayer.system.core;

import java.time.temporal.ChronoUnit;

/**
 * This class defines the balance of a user.
 * <p>
 * This balance store the number of ride, total time spend on a bike, total charges, and total time credit get.
 * @see User
 * </p>
 */
public class UserBalance {
	protected int numberOfRide;
	protected int totalTime;
	protected double totalCharges;
	protected int totalTimeCredit;
	
	/** Creates a balance and initialize its values to zero.*/
	public UserBalance() {
		super();
		this.numberOfRide = 0;
		this.totalTime = 0;
		this.totalCharges = 0;
		this.totalTimeCredit = 0;
	}

	/** Increment the number of ride (+1) and update the other statistics with the ride data.*/
	public void addRide(Ride ride) {
		numberOfRide++;
		double duration = ChronoUnit.MINUTES.between(ride.getStartTime(), ride.getEndTime());
		totalTime += duration;
		totalCharges+=ride.cost;
	}
	
	/** Add time credit of a given amount to the total time credit.*/
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
		return "\n> Rides : " + numberOfRide + "           | Time on bike : " + totalTime + " \n> Total charges : "
				+ totalCharges + " | Time credit : " + totalTimeCredit + ".";
	}










}
