package myVelibProject.tests;

import myVelibProject.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDrivenDevelopmentMyVelib {
	private MyVelib system;
	private DockingStation S;
	
	@BeforeEach
	void setUp() throws GeneralException {
		system = new MyVelib(10, 10, 0.7, 0.7, 0.5);
		system.addUser(new User("Jean", new Coordinates(1,1), "Vlibre", 100));
		system.addUser(new User("Alex", new Coordinates(2,2), "Vmax", 100));
		system.addUser(new User("Clara", new Coordinates(7,8), null, 100));
	}

	@Test
	void testInitNumber() {
		// Checking if the system has the correct number of element
		assertEquals(system.getStationList().size(), 10);
		assertEquals(system.getBicycleList().size(), 70);
		assertEquals(system.getUserList().size(), 3);
	}
	
	@Test
	void testInitRepartition() {
		// Checking if the system made the bicycle repartition we asked for
		int nbElec = 0;
		int nbMeca = 0;
		for (Bicycle b : system.getBicycleList()) {
			if (b.getType()=="electrical") {
				nbElec += 1;
			}
			else if(b.getType()=="mecanical") {
				nbMeca += 1;
			}	
		}
		
		assertEquals(nbElec, 21);
		assertEquals(nbMeca, 49);
	}
	
	@Test
	void testInitStationInSquare() {
		// Checking if the stations are in the 10x10 square
		for (DockingStation s : system.getStationList()) {
			assertTrue(s.getGps().getX() >= 0 && s.getGps().getX() <= 10);
			assertTrue(s.getGps().getY() >= 0 && s.getGps().getY() <= 10);
		}
	}
	
	@Test
	void testGetUserFromID() throws GeneralException {
		// Checking if the method works as expected
		assertEquals(system.getUserFromID(1).getName(), "Jean");
		assertEquals(system.getUserFromID(2).getName(), "Alex");
		assertEquals(system.getUserFromID(3).getName(), "Clara");
	}
	
	@Test
	void testDockingStation() throws GeneralException {
		// Checking the correct implementation of all the parameters when a bicycle is added
		S = new DockingStation(new Coordinates(1,1), null, 2);
		
		assertEquals(S.getNumberOfSlotsOccupied(), 0);
		assertEquals(S.getNumberOfSlots(), 2);
		
		S.addBicycle(new Bicycle(new Coordinates(2,4), "mecanical"));
		assertEquals(S.getNumberOfSlotsOccupied(), 1);
		assertEquals(S.getNumberOfMecanicalBicycle(), 1);
		assertEquals(S.getNumberOfElectricalBicycle(), 0);
		
		S.addBicycle(new Bicycle(new Coordinates(3,7), "electrical"));
		assertEquals(S.getNumberOfSlotsOccupied(), 2);
		assertEquals(S.getNumberOfMecanicalBicycle(), 1);
		assertEquals(S.getNumberOfElectricalBicycle(), 1);
		
		assertThrows(Exception.class, () -> {
			S.addBicycle(new Bicycle(new Coordinates(3,7), "electrical"));
		});
		
		assertEquals(S.getParkingSlotList().get(0).getParkedBicycle().getType(), "mecanical");
		assertEquals(S.getParkingSlotList().get(1).getParkedBicycle().getType(), "electrical");
		
	}
	

}
