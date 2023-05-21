package myVelibProject;

import java.time.temporal.ChronoUnit;

public class VmaxStrategy implements CostStrategy {

	@Override
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
