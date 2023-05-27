package tests.core;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import system.core.*;

class TestUserBalance {
	private MyVelib myVelib;
	private Renter renter;
	private User u;
	private LocalTime st;
	private LocalTime et;
	private DockingStation edsplus;
	private DockingStation eds;
	private Bicycle b;



	@BeforeEach
	void setUp() throws GeneralException {
		myVelib = new MyVelib(2,10,0.9,0.5,0.5, 10);
		renter = new Renter(myVelib);
		u = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		myVelib.addUser(u);
		st = LocalTime.of(6, 45);
		et = LocalTime.of(10, 15);
		edsplus = myVelib.getStationList().get(0);
		eds = myVelib.getStationList().get(1);
		b = new Bicycle(new Coordinates(1.234,1.546), "mecanical");

	}
	@Test
	/** test if the add of a ride is functionnal*/
	void testAddRide() throws GeneralException {
		UserBalance balance = u.getBalance();

		assertEquals(balance.getNumberOfRide(), 0);
		assertEquals(balance.getTotalCharges(), 0);
		assertEquals(balance.getTotalTime(), 0);

		renter.connectUser(u);
		renter.setItinerary(new StreetToStationItinerary(b, eds, null));
		renter.rentBicycle(st);
		renter.returnBicycle(et);

		assertEquals(balance.getNumberOfRide(), 1);
		assertEquals(balance.getTotalCharges(), 2.25);
		assertEquals(balance.getTotalTime(), 210);
		assertEquals(balance.getTotalTimeCredit(), 0);
	}

	@Test
	/** test if the add of a ride is functionnal*/
	void testAddRidePlus() throws GeneralException {
		UserBalance balance = u.getBalance();

		assertEquals(balance.getNumberOfRide(), 0);
		assertEquals(balance.getTotalCharges(), 0);
		assertEquals(balance.getTotalTime(), 0);

		renter.connectUser(u);
		renter.setItinerary(new StreetToStationItinerary(b, edsplus, null));
		renter.rentBicycle(st);
		renter.returnBicycle(et);

		assertEquals(balance.getNumberOfRide(), 1);
		assertEquals(balance.getTotalCharges(), 2.25);
		assertEquals(balance.getTotalTime(), 210);
		assertEquals(balance.getTotalTimeCredit(), 5);
	}



}
