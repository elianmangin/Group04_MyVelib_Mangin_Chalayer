package myVelibProject.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myVelibProject.system.core.*;

class TestRenter {
	private Renter renter;
	
	@BeforeEach
	void setUp() throws GeneralException {
		MyVelib system = new MyVelib(10,10,0.9,0.5,0.5, 10);
		renter = new Renter(system);
	}	
	
	@Test
	void testUserConnection() throws GeneralException {
		// Test userConnect and userDisconnect methods
		User user1 = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		User user2 = new User("Pierre", new Coordinates(1.234,1.546), "Vlibre", 100);
		renter.connectUser(user1);
		assertEquals(user1, renter.getUser());
		Exception exception = assertThrows(GeneralException.class, () -> {
			renter.connectUser(user2);
		});
		renter.disconnectUser();
		assertEquals(null, renter.getUser());
	}
	
	@Test
	void testAskRidePlanning() throws GeneralException {
		// Test the askPlanning method
		User user1 = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		Exception exception = assertThrows(GeneralException.class, () -> {
			renter.askPlanning(new Coordinates(1.4,1.5), "mecanical", "STANDARD");
		});
		renter.connectUser(user1);
		renter.askPlanning(new Coordinates(1.4,1.5), "mecanical", "STANDARD");
		assertNotNull(renter.getItinerary());
	}
	
	@Test
	void testRentBicycleFromStreet() throws GeneralException {
		// Test the askPlanning method
		Bicycle b1 = new Bicycle(new Coordinates(1.234,1.546), "mecanical");
		User user1 = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		Exception exception = assertThrows(GeneralException.class, () -> {
			renter.rentBicycle(LocalTime.of(4, 15));
		});
		renter.connectUser(user1);
		renter.setItinerary(new StreetToStationItinerary(b1,null, null));
		renter.rentBicycle(LocalTime.of(4, 15));
		assertTrue(b1.isCurrentlyRentedBicycle());
		assertNotNull(user1.getCurrentRide());
	}
}