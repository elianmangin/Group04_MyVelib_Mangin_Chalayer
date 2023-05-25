package myVelibProject.system.core;

/**
 * Strategy to compute the cost of a ride.
 */
public interface CostStrategy {
	
	public double calculate(Ride ride) throws GeneralException;

}
