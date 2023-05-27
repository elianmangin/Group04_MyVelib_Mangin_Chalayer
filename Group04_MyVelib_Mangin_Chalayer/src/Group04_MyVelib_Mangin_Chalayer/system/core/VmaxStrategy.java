package Group04_MyVelib_Mangin_Chalayer.system.core;

import java.time.temporal.ChronoUnit;

/**
 * Strategy to compute the cost of a ride for a user with a Vmax card.
 */
public class VmaxStrategy implements CostStrategy {

	@Override
	/** Compute the cost of a given ride.*/
	public double calculate(Ride ride) {
		double cost = 0;
		double duration = ChronoUnit.MINUTES.between(ride.startTime, ride.endTime);

		duration = duration-60;
		if(duration <0) {return 0;}
		else {cost = duration/60;}

		if(ride.startStation == null && ride.endStation !=null) {return 0.9*cost;}
		if(ride.endStation ==null) {return 1.1*cost;}
		else {return cost;}
	}

}
