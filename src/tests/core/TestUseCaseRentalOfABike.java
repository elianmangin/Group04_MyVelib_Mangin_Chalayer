package tests.core;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import system.core.*;

/**
 * Junit test of the scenario rental of a bike
 */
public class TestUseCaseRentalOfABike {
	private MyVelib myVelib;
	private Renter renter;
	private User user1;
	private User user2;
	private User user3;

	@BeforeEach
	void setUp() throws GeneralException {
		myVelib = new MyVelib(10,10,0.9,0.5,0.5, 10);
		user1 = new User("John",new Coordinates(0, 0), "Vlibre", 100);
		user2 = new User("Artur",new Coordinates(0, 0), "Vmax",100);
		user3 = new User("Paul",new Coordinates(0, 0), null, 100);
		myVelib.addUser(user1);
		myVelib.addUser(user2);
		myVelib.addUser(user3);
		renter = new Renter(myVelib);

	}

	
	/** Verify that the user is on ride after renting and not on ride after return*/
	@Test
	public void test() throws GeneralException {
		renter.connectUser(user1);
		assertEquals(renter.getUser().getName(), "John");
		renter.askPlanning(new Coordinates(5,6), "mecanical", "standard");
		renter.rentBicycle(LocalTime.of(4, 45));
		assertTrue(renter.getUser().isCurrentlyRenting());
		renter.returnBicycle(LocalTime.of(6, 48));
		assertFalse(user1.isCurrentlyRenting());
	}
}
	
	
