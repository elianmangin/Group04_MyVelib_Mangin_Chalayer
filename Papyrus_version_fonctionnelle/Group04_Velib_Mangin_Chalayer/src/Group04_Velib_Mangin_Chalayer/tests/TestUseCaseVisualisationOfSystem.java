package Group04_Velib_Mangin_Chalayer.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Group04_Velib_Mangin_Chalayer.system.Coordinates;
import Group04_Velib_Mangin_Chalayer.system.DockingStation;
import Group04_Velib_Mangin_Chalayer.system.GeneralException;
import Group04_Velib_Mangin_Chalayer.system.MyVelib;
import Group04_Velib_Mangin_Chalayer.system.User;

class TestUseCaseVisualisationOfSystem {
	private MyVelib system;
	private User user1;
	private User user2;
	private User user3;
	
	@BeforeEach
	void setup() throws GeneralException {
		User.setIdCounterUser(0);
		DockingStation.setIdCounterStation(0);
		system = new MyVelib(10,10,0.9,0.5,0.5, 10);
		user1 = new User("John",new Coordinates(0, 0), "Vlibre", 100);
		user2 = new User("Artur",new Coordinates(0, 0), "Vmax",100);
		user3 = new User("Paul",new Coordinates(0, 0), null, 100);
		system.addUser(user1);
		system.addUser(user2);
		system.addUser(user3);
	}
	
	@Test
	void testStateOfUserFromID() throws GeneralException {
		//Test the method getUserFromId to see the state of a user
		assertEquals(system.getUserFromID(user1.getUniqID()), user1);
		assertEquals(system.getUserFromID(user2.getUniqID()), user2);
		assertEquals(system.getUserFromID(user3.getUniqID()), user3);
	}
	
	@Test
	void testStateOfStationFromID() throws GeneralException {
		//Test the method getUserFromId to see the state of a user
		assertEquals(system.getStationFromID(1), system.getStationList().get(0));
		assertEquals(system.getStationFromID(2), system.getStationList().get(1));
		assertEquals(system.getStationFromID(3), system.getStationList().get(2));
	}
	
	@Test
	void testReportUser() throws GeneralException {
		//Test the method getUserFromId to see the state of a user
		System.out.print(user1);
		//Visual confirmation of the informations displayed
	}
	
	@Test
	void testReportStation() throws GeneralException {
		//Test the method getUserFromId to see the state of a user
		System.out.print(system.getStationFromID(1));
		//Visual confirmation of the informations displayed
	}
	
	@Test
	void testReportSystem() throws GeneralException {
		//Test the method getUserFromId to see the state of a user
		system.report(); //modifier par ligne de commande?
		
		//Visual confirmation of the informations displayed
	}
	

	
}
