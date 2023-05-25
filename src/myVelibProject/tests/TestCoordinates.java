package myVelibProject.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myVelibProject.system.core.Coordinates;

class TestCoordinates {
	private Coordinates coord;
	
	@BeforeEach
	void setUp() {
		coord = new Coordinates(48.7102069003148, 2.1662276002460428);
	}

	@Test
	void testGetters() {
		//test the getters of Coordinates
		assertEquals(coord.getX(),48.7102069003148);
		assertEquals(coord.getY(),2.1662276002460428);
		
	}
	
	@Test
	void testEqual() {
		//test the method to know if two coordinates are equals
		Coordinates coord2 = new Coordinates(48.7102069003148, 2.1662276002460428);
		Coordinates coord3 = new Coordinates(56.7108069003148, 2.1662276002460428);
		assertTrue(coord.equals(coord2));
		assertFalse(coord.equals(coord3));
	}
	
	@Test
	void testDistance() {
		//test the method to know if two coordinates are equals
		Coordinates coord2 = new Coordinates(48.7102069003148, 7.1127589002460428);
		Coordinates coord3 = new Coordinates(56.7108069003148, 2.1662276002460428);
		assertEquals(coord2.distance(coord3), Math.sqrt(Math.pow(48.7102069003148-56.7108069003148,2)+Math.pow(7.1127589002460428-2.1662276002460428,2)));
		
	}

}
