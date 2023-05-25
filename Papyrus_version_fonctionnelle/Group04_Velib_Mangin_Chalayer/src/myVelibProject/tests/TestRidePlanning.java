package myVelibProject.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myVelibProject.system.core.*;

class TestRidePlanning {
	private RideItinerary itinerary;
	private RidePlanning RP;
	private User user;
	private MyVelib system;
	
	@BeforeEach
	void setUp() throws GeneralException {
		user = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		system = new MyVelib(10,10,0.9,0.5,0.5, 10);
		PlanningFactory PF = new PlanningFactory();
		RP = PF.create("STANDARD", system);
	}
	
	@Test
	void testStartAndEnd() throws GeneralException {
		//Verify that the DockingStation are in the system and the bicycle is of the good type
		itinerary = RP.plan(user.getGps(),new Coordinates(1.3,1.8), "mecanical");
		assertTrue(system.getStationList().contains(itinerary.getStart()));
		assertTrue(system.getStationList().contains(itinerary.getEnd()));
		assertEquals(itinerary.getType(), "mecanical");
	}
	
	@Test
	void testType() throws GeneralException {
		//Verify that the DockingStation are in the system and the bicycle is of the good type
		itinerary = RP.plan(user.getGps(),new Coordinates(1.3,1.8), "mecanical");
		assertEquals(itinerary.getType(), "mecanical");
		itinerary = RP.plan(user.getGps(),new Coordinates(1.3,1.8), "electrical");
		assertEquals(itinerary.getType(), "electrical");
	}
	
	@Test
	void testNearestStation() throws GeneralException {
		//Verify that the DockingStation are in the system and the bicycle is of the good type
		itinerary = RP.plan(user.getGps(),new Coordinates(1.3,1.8), "mecanical");
		ArrayList<DockingStation> stationList = system.getStationList();
		double minDistanceStart = Double.POSITIVE_INFINITY;
		double minDistanceEnd = Double.POSITIVE_INFINITY;
		DockingStation minDockingStationStart = null;
		DockingStation minDockingStationEnd = null;
		for (DockingStation dockingStation : stationList) {
			
			double distanceStart = user.getGps().distance(dockingStation.getGps());
			if (distanceStart < minDistanceStart) {
				minDistanceStart = distanceStart;
				minDockingStationStart = dockingStation;
			}
			
			double distanceEnd = (new Coordinates(1.3,1.8)).distance(dockingStation.getGps());
			if (distanceEnd < minDistanceEnd) {
				minDistanceEnd = distanceEnd;
				minDockingStationEnd = dockingStation;
			}
			
		}
		assertEquals(minDockingStationStart,itinerary.getStart() );
		assertEquals(minDockingStationEnd,itinerary.getEnd() );
		}
	}

