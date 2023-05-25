package Group04_MyVelib_Mangin_Chalayer.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Group04_MyVelib_Mangin_Chalayer.system.core.*;

class TestUserBalance {
	private User u;
	private LocalTime st;
	private LocalTime et;
	private DockingStation edsplus;
	private DockingStation eds;
	private Bicycle b;

	

	@BeforeEach
	void setUp() throws GeneralException {
		this.u = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		this.st = LocalTime.of(6, 45);
		this.et = LocalTime.of(10, 15);
		this.edsplus = new DockingStation(new Coordinates(6.908,4.767),"plus",10);
		this.eds = new DockingStation(new Coordinates(2.301,8.547),null,10);
		this.b = new Bicycle(new Coordinates(7.151,1.677), "mecanical");
		
	}
	@Test
	void testAddRide() throws GeneralException {
		//test if the add of a ride is functionnal
		Ride ride = new Ride(u, b, st);
		ride.endRide(eds, et);
		UserBalance balance = new UserBalance();
		
		assertEquals(balance.getNumberOfRide(), 0);
		assertEquals(balance.getTotalCharges(), 0);
		assertEquals(balance.getTotalTime(), 0);
		
		balance.addRide(ride);
		
		assertEquals(balance.getNumberOfRide(), 1);
		assertEquals(balance.getTotalCharges(), ride.getCost());
		assertEquals(balance.getTotalTime(), ChronoUnit.MINUTES.between(ride.getStartTime(), ride.getEndTime()));
		assertEquals(balance.getTotalTimeCredit(), 0);
	}
	
	@Test
	void testAddRidePlus() throws GeneralException {
		//test if the add of a ride with the add of 5 minutes to the totaltimecredit
		Ride rideplus = new Ride(u, b, st);
		rideplus.endRide(edsplus, et);
		UserBalance balance = new UserBalance();
		
		assertEquals(balance.getNumberOfRide(), 0);
		assertEquals(balance.getTotalCharges(), 0);
		assertEquals(balance.getTotalTime(), 0);
		
		balance.addRide(rideplus);
		
		assertEquals(balance.getNumberOfRide(), 1);
		assertEquals(balance.getTotalCharges(), rideplus.getCost());
		assertEquals(balance.getTotalTime(), ChronoUnit.MINUTES.between(rideplus.getStartTime(), rideplus.getEndTime()));
		assertEquals(balance.getTotalTimeCredit(), 5);
		//Pas d'ajout de TotalTimeCredit c'est normal cela est fait par le renter en temps normal
	}
	
	

}
