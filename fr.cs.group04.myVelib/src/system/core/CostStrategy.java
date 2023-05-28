package system.core;

/**
 * Strategy to compute the cost of a ride.
 */
public interface CostStrategy {
	
	/** Compute the cost of a given ride.*/
	public double calculate(Ride ride) throws GeneralException;

}
