package Group04_Velib_Mangin_Chalayer.tests;

import Group04_Velib_Mangin_Chalayer.system.User;
import Group04_Velib_Mangin_Chalayer.system.Coordinates;
import Group04_Velib_Mangin_Chalayer.system.GeneralException;
import Group04_Velib_Mangin_Chalayer.system.MyVelib;
import Group04_Velib_Mangin_Chalayer.system.Ride;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestUser {
	private MyVelib system;
	private User user1;
	private User user2;
	private User user3;
	@BeforeEach
	void setUp() throws GeneralException {
		system = new MyVelib(10, 10, 0.7, 0.7, 0.5, 10);
		user1 = new User("Jean", new Coordinates(1,1), "Vlibre", 100);
		user2 = new User("Alex", new Coordinates(2,2), "Vmax", 100);
		user3 = new User("Clara", new Coordinates(7,8), null, 100); 
		system.addUser(user1);
		system.addUser(user2);
		system.addUser(user3);
	}
	
	@Test
	void testGetUserFromID() throws GeneralException {
		// Checking if the method works as expected
		assertEquals(system.getUserFromID(user1.getUniqID()).getName(), "Jean");
		assertEquals(system.getUserFromID(user2.getUniqID()).getName(), "Alex");
		assertEquals(system.getUserFromID(user3.getUniqID()).getName(), "Clara");
	}
	@Test
	void testUniqID() {
		//Test id the id are uniques
		assertNotEquals(user1.getUniqID(),user2.getUniqID());
		assertNotEquals(user1.getUniqID(),user3.getUniqID());
		assertNotEquals(user3.getUniqID(),user2.getUniqID());
	}
	@Test
	void testGetters() throws GeneralException {
		// Test the getters and setters
		assertTrue(user1.getGps().equals(new Coordinates(1,1)));
		assertTrue(user2.getGps().equals(new Coordinates(2,2)));
		assertTrue(user3.getGps().equals(new Coordinates(7,8)));
		assertEquals(user1.getName(),"Jean");
		assertEquals(user2.getName(),"Alex");
		assertEquals(user3.getName(),"Clara");
		assertEquals(user1.getCreditBalance(), 100);
		assertEquals(user2.getCreditBalance(), 100);
		assertEquals(user3.getCreditBalance(), 100);
		assertEquals(user1.getRegistrationCard().getType(),"Vlibre");
		assertEquals(user2.getRegistrationCard().getType(),"Vmax");
		assertEquals(user3.getRegistrationCard().getType(),null);
		assertFalse(user1.isCurrentlyRenting());
		assertFalse(user2.isCurrentlyRenting());
		assertFalse(user3.isCurrentlyRenting());
	}
	
	@Test
	void testCharging() throws GeneralException {
		// Test the charging method
		assertEquals(user1.getCreditBalance(), 100);
		assertEquals(user2.getCreditBalance(), 100);
		assertEquals(user3.getCreditBalance(), 100);
		user1.charge(23);
		user2.charge(23.5);
		assertEquals(user1.getCreditBalance(), 77d);
		assertEquals(user2.getCreditBalance(), 76.5);
		Exception exception = assertThrows(GeneralException.class, () -> {
			user3.charge(-4.5);
		});
		
	}
	
}
