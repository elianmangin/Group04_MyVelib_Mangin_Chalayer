package system.core;

import java.time.temporal.ChronoUnit;

/**
 * Strategy to compute the cost of a ride for a user without card.
 */
public class NoCardStrategy implements CostStrategy {

	@Override
	/** Compute the cost of a given ride.*/
	public double calculate(Ride ride) {
		double cost = 0;
		double duration = ChronoUnit.MINUTES.between(ride.startTime, ride.endTime);

		if (ride.bicycleUsed.getType()=="mecanical") {cost = duration/60;}
		if (ride.bicycleUsed.getType()=="electrical") {cost = 2*duration/60;}

		if(ride.startStation == null && ride.endStation !=null) {return 0.9*cost;}
		if(ride.endStation ==null) {return 1.1*cost;}
		else {return cost;}
	}

}
