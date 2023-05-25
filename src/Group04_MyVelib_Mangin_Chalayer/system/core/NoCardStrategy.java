package Group04_MyVelib_Mangin_Chalayer.system.core;

import java.time.temporal.ChronoUnit;

public class NoCardStrategy implements CostStrategy {

	@Override
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
