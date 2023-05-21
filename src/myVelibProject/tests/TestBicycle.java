package myVelibProject.tests;

import myVelibProject.Coordinates;
import myVelibProject.Bicycle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBicycle {
	private Bicycle bicycle1;
	private Bicycle bicycle2;
	private Bicycle bicycle3;
	private Bicycle bicycle4;
	private Bicycle bicycle5;
	private Coordinates coordCS;
	
	@BeforeEach
	void setUp() {
		coordCS = new Coordinates(48.7102069003148, 2.1662276002460428);
		bicycle1 = new Bicycle(new Coordinates(48.7102069003148, 2.1662276002460428), "mecanical");	
		bicycle2 = new Bicycle(new Coordinates(48.71115801173848, 2.162402249270749), "electrical");	
		bicycle3 = new Bicycle(new Coordinates(48.70829819232185, 2.1615321467445616), "electrical");	
		bicycle4 = new Bicycle(new Coordinates(48.70489703744113, 2.191273394996826), "mecanical");	
		bicycle5 = new Bicycle(new Coordinates(48.72582008134524, 2.2614787898585686), "electrical");	
		
	}

	@Test
	void testGetCoord() {
		assertEquals(bicycle1.getGps(), coordCS);
	}
	
	@Test
	void testUniqID() {
		assertNotEquals(bicycle1.getUniqID(),bicycle2.getUniqID());
		assertNotEquals(bicycle1.getUniqID(),bicycle4.getUniqID());
		assertNotEquals(bicycle2.getUniqID(),bicycle3.getUniqID());
		assertNotEquals(bicycle2.getUniqID(),bicycle5.getUniqID());
		assertNotEquals(bicycle3.getUniqID(),bicycle1.getUniqID());
		assertNotEquals(bicycle3.getUniqID(),bicycle4.getUniqID());
		assertNotEquals(bicycle4.getUniqID(),bicycle5.getUniqID());
		assertNotEquals(bicycle4.getUniqID(),bicycle2.getUniqID());
		assertNotEquals(bicycle5.getUniqID(),bicycle3.getUniqID());
		assertNotEquals(bicycle5.getUniqID(),bicycle1.getUniqID());
	}
	
	@Test
	void testCurrRent() {
		assertFalse(bicycle1.isCurrentlyRentedBicycle());
		bicycle1.setCurrentlyRentedBicycle(true);
		assertTrue(bicycle1.isCurrentlyRentedBicycle());
		bicycle1.setCurrentlyRentedBicycle(false);
		assertFalse(bicycle1.isCurrentlyRentedBicycle());
	}

}
