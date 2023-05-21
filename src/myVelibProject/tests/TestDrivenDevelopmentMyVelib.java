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
		assertEquals(system.getStationList().size(), 10);
		assertEquals(system.getBicycleList().size(), 100);
		assertEquals(system.getUserList().size(), 3);
	}
	
	@Test
	void testInitRepartition() {
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
		for (DockingStation s : system.getStationList()) {
			assertTrue(s.getGps().getX() >= 0 && s.getGps().getX() <= 10);
			assertTrue(s.getGps().getY() >= 0 && s.getGps().getY() <= 10);
		}
	}
	
	@Test
	void testGetUserFromID() {
		assertEquals(system.getUserFromID(0).getName(), "Jean");
		assertEquals(system.getUserFromID(1).getName(), "Alex");
		assertEquals(system.getUserFromID(1).getName(), "Clara");
	}
	
	@Test
	void testDockingStation() throws GeneralException {
		S = new DockingStation(new Coordinates(1,1), null, 2);
		
		assertEquals(S.getNumberOfSlotsOccupied(), 0);
		assertEquals(S.getNumberOfSlots(), 2);
		
		Bicycle meca = S.takeBicycle("mecanical");
		assertEquals(S.getNumberOfSlotsOccupied(), 1);
		assertEquals(S.getNumberOfMecanicalBicycle(), 1);
		assertEquals(S.getNumberOfElectricalBicycle(), 0);
		
		Bicycle elec = S.takeBicycle("electrical");
		assertEquals(S.getNumberOfSlotsOccupied(), 2);
		assertEquals(S.getNumberOfMecanicalBicycle(), 1);
		assertEquals(S.getNumberOfElectricalBicycle(), 1);
		
		assertThrows(Exception.class, () -> {
			S.takeBicycle("mecanical");
		});
		
		assertEquals(meca.getType(), "mecanical");
		assertEquals(elec.getType(), "electrical");
		
	}
	

}
