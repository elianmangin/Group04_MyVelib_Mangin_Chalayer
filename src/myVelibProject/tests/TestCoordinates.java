package myVelibProject.tests;

import myVelibProject.Coordinates;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCoordinates {
	private Coordinates coord;
	
	@BeforeEach
	void setUp() {
		coord = new Coordinates(48.7102069003148, 2.1662276002460428);
	}

	@Test
	void testLatitude() {
		assertEquals(coord.getX(),48.7102069003148);
		
	}
	
	@Test
	void testLongitude() {
		assertEquals(coord.getY(),2.1662276002460428);
		
	}
	
	@Test
	void testEqual() {
		Coordinates coord2 = new Coordinates(48.7102069003148, 2.1662276002460428);
		assertEquals(coord,coord2);
		
	}

}
