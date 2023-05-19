package myVelibProject.tests;

import myVelibProject.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fs.cs.is1220.TP8_CHALAYER.exo1.Factorial;
import fs.cs.is1220.TP8_CHALAYER.exo1.IllegalValue;

class TestDrivenDevelopmentMyVelib {
	private MyVelib system;
	private DockingStation S;
	
	@BeforeEach
	void setUp() {
		system = new MyVelib(10, 100);
		system.addUser(new User("Jean", new Coordinates(1,1), "Vlibre"));
		system.addUser(new User("Alex", new Coordinates(2,2), "Vmax"));
		system.addUser(new User("Clara", new Coordinates(7,8));
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
			assertTrue(s.getGps().getLatitude() >= 0 && s.getGps().getLatitude() <= 10);
			assertTrue(s.getGps().getLongitude() >= 0 && s.getGps().getLongitude() <= 10);
		}
	}
	
	@Test
	void testGetUserFromID() {
		assertEquals(system.getUserFromID(0).getName(), "Jean");
		assertEquals(system.getUserFromID(1).getName(), "Alex");
		assertEquals(system.getUserFromID(1).getName(), "Clara");
	}
	
	@Test
	void testDockingStation() {
		S = new DockingStation(new Coordinates(1,1), null, 2);
		
		assertEquals(S.getNumberOfSlotsOccupied(), 0);
		assertEquals(S.getNumberOfSlots(), 2);
		
		S.recieiveBicycle(new Bicycle(new Coordinates(1,1), "mecanical"));
		assertEquals(S.getNumberOfSlotsOccupied(), 1);
		assertEquals(S.getNumberOfMecanicalBicycle(), 1);
		assertEquals(S.getNumberOfElectricalBicycle(), 0);
		
		S.recieiveBicycle(new Bicycle(new Coordinates(1,1), "electrical"));
		assertEquals(S.getNumberOfSlotsOccupied(), 2);
		assertEquals(S.getNumberOfMecanicalBicycle(), 1);
		assertEquals(S.getNumberOfElectricalBicycle(), 1);
		
		assertThrows(Exception.class, () -> {
			S.recieiveBicycle(new Bicycle(new Coordinates(1,1), "mecanical"));
		});
		
		assertEquals(S.find("mecanical").getType(), "mecanical");
		assertEquals(S.find("electrical").getType(), "electrical");
		
	}
	
	@Test
	void testRide() {
		Ride R1 = new Ride(new User("Jean", new Coordinates(1,1), "Vlibre"), new Coordinates(1,1), LocalTime.of(5,15), S, "electrical");
		R1.endRide(LocalTime.of(7,30), new Coordinates(1,8));
		
		assertEquals(R1.getBicycleUsed().getGps(), new Coordinates(1,8));
		assertEquals(R1.getCost(), 5);	
		
		Ride R2 = new Ride(new User("Jean", new Coordinates(1,1), "Vmax"), new Coordinates(1,1), LocalTime.of(5,15), S, "electrical");
		R2.endRide(LocalTime.of(7,30), new Coordinates(1,8));
		
		assertEquals(R2.getCost(), 2);	
	}

}
