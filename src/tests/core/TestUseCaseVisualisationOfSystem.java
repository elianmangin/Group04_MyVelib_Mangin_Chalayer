package tests.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import system.core.*;

class TestUseCaseVisualisationOfSystem {
	private MyVelib system;
	private User user1;
	private User user2;
	private User user3;
	
	@BeforeEach
	void setup() throws GeneralException {
		system = new MyVelib(10,10,0.9,0.5,0.5, 10);
		user1 = new User("John",new Coordinates(0, 0), "Vlibre", 100);
		user2 = new User("Artur",new Coordinates(0, 0), "Vmax",100);
		user3 = new User("Paul",new Coordinates(0, 0), null, 100);
		system.addUser(user1);
		system.addUser(user2);
		system.addUser(user3);
	}
	
	@Test
	/** Test the method getUserFromId to see the state of a user*/
	void testStateOfUserFromID() throws GeneralException {
		assertEquals(system.getUserFromID(user1.getUniqID()), user1);
		assertEquals(system.getUserFromID(user2.getUniqID()), user2);
		assertEquals(system.getUserFromID(user3.getUniqID()), user3);
	}
	
	@Test
	/** Test the method getStationFromId to see the state of a user*/
	void testStateOfStationFromID() throws GeneralException {
		assertEquals(system.getStationFromID(1), system.getStationList().get(0));
		assertEquals(system.getStationFromID(2), system.getStationList().get(1));
		assertEquals(system.getStationFromID(3), system.getStationList().get(2));
	}
	
	@Test
	/** Test the method getUserFromId to see the state of a user. 
	 * Visual confirmation of the informations displayed*/
	void testReportUser() throws GeneralException {
		System.out.print(user1);
	}
	
	@Test
	/**Test the method getUserFromId to see the state of a user
	 * Visual confirmation of the informations displayed*/
	void testReportStation() throws GeneralException {
		System.out.print(system.getStationFromID(1));
	}
	
	@Test
	/** Test the method getUserFromId to see the state of a user
	 * Visual confirmation of the informations displayed*/
	void testReportSystem() throws GeneralException {
		system.report();
	}
	

	
}
