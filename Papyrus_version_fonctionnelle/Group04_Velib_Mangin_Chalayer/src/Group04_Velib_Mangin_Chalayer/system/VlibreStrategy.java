package Group04_Velib_Mangin_Chalayer.system;

import java.time.temporal.ChronoUnit;

public class VlibreStrategy implements CostStrategy {

	@Override
	public double calculate(Ride ride) {
		//Créer une exception au lieu de return 0 à la fin
		double cost = 0;
		double timeCredit = ride.user.registrationCard.getBalance();
		double duration = ChronoUnit.MINUTES.between(ride.startTime, ride.endTime);

		duration = duration-60;
		if(duration <0) {return 0;}
		else if(timeCredit > duration) {
			ride.user.registrationCard.removeCredit((int)duration); // ((int)timeCredit-(int)duration);
			return 0;
		}
		else if(timeCredit <= duration) {
			ride.user.registrationCard.setBalance(0);
			duration = duration-timeCredit;
			if (ride.bicycleUsed.getType()=="mecanical") { cost = duration/60;}
			if (ride.bicycleUsed.getType()=="electrical") {cost = 1+2*duration/60;}
		}

		if(ride.startStation == null && ride.endStation !=null) {return 0.9*cost;}
		if(ride.endStation ==null) {return 1.1*cost;}
		else {return cost;}
	}

}
