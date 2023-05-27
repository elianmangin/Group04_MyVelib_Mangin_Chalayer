package Group04_MyVelib_Mangin_Chalayer.tests.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Group04_MyVelib_Mangin_Chalayer.system.core.*;

class TestUseCaseRidePlanning {
	private MyVelib system;
	private User user;
	private Renter renter;
	
	@BeforeEach
	void setUp() throws GeneralException {
		this.system = new MyVelib(0,0,0,0,0, 10);
		DockingStation S1 = new DockingStation(new Coordinates(1, 1), null, 2);
		S1.addBicycle(new Bicycle(new Coordinates(1, 1), "mecanical"));
		DockingStation S2 = new DockingStation(new Coordinates(6, 2), null, 2);
		S2.addBicycle(new Bicycle(new Coordinates(9, 3), "mecanical"));
		DockingStation S3 = new DockingStation(new Coordinates(7, 5), null, 2);
		S3.addBicycle(new Bicycle(new Coordinates(7, 5), "mecanical"));
		DockingStation S4 = new DockingStation(new Coordinates(4, 9), null, 2);
		S4.addBicycle(new Bicycle(new Coordinates(4, 9), "electrical"));
		DockingStation S5 = new DockingStation(new Coordinates(2, 6), null, 2);
		S5.addBicycle(new Bicycle(new Coordinates(2, 6), "electrical"));
		S5.addBicycle(new Bicycle(new Coordinates(2, 6), "electrical"));
		ArrayList<DockingStation> stationList = new ArrayList<DockingStation>(Arrays.asList(S1,S2,S3,S4,S5));
		this.system.setStationList(stationList);
		this.user = new User("Axel", new Coordinates(0,0), null, 100);
		this.system.addUser(user);
		this.renter = new Renter(system);
		this.renter.connectUser(user);
		
		
	}
	
	@Test
	void testStandardStart1() throws GeneralException {
		renter.askPlanning(new Coordinates(10,10), "mecanical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getStart()).getUniqID(), 1);
		
	}
	
	@Test
	void testStandardStart2() throws GeneralException {
		this.user.setGps(new Coordinates(7.5, 6));
		renter.askPlanning(new Coordinates(10,10), "mecanical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getStart()).getUniqID(), 3);
		
	}
	
	@Test
	void testStandardStart3() throws GeneralException {
		this.user.setGps(new Coordinates(4.9, 1.9));
		renter.askPlanning(new Coordinates(10,10), "mecanical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getStart()).getUniqID(), 2);
		
	}
	
	@Test
	void testStandardStart4() throws GeneralException {
		this.user.setGps(new Coordinates(8.5, 5.5));
		renter.askPlanning(new Coordinates(10,10), "electrical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getStart()).getUniqID(), 4);
		
	}
	
	@Test
	void testStandardStart5() throws GeneralException {
		this.user.setGps(new Coordinates(1.8, 6.8));
		renter.askPlanning(new Coordinates(10,10), "electrical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getStart()).getUniqID(), 5);
		
	}
	
	@Test
	void testStandardStart6() throws GeneralException {
		this.user.setGps(new Coordinates(0.5, 2.7));
		renter.askPlanning(new Coordinates(10,10), "mecanical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getStart()).getUniqID(), 1);
		
	}
	
	@Test
	void testStandardEnd1() throws GeneralException {
		renter.askPlanning(new Coordinates(1.5, 0.95), "mecanical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getEnd()).getUniqID(), 1);
		
	}
	
	@Test
	void testStandardEnd2() throws GeneralException {
		renter.askPlanning(new Coordinates(7.5, 6), "mecanical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getEnd()).getUniqID(), 3);
		
	}
	
	@Test
	void testStandardEnd3() throws GeneralException {
		renter.askPlanning(new Coordinates(4.9, 1.9), "mecanical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getEnd()).getUniqID(), 2);
		
	}
	
	@Test
	void testStandardEnd4() throws GeneralException {
		renter.askPlanning(new Coordinates(8.5, 5.5), "electrical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getEnd()).getUniqID(), 3);
		
	}
	
	@Test
	void testStandardEnd5() throws GeneralException {
		renter.askPlanning(new Coordinates(1.8, 6.8), "electrical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getEnd()).getUniqID(), 4);
		
	}
	
	@Test
	void testStandardEnd6() throws GeneralException {
		renter.askPlanning(new Coordinates(0.5, 2.7), "mecanical", "standard");
		assertEquals(((DockingStation)renter.getItinerary().getEnd()).getUniqID(), 1);
		
	}

}
