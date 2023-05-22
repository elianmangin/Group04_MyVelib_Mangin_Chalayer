package myVelibProject.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myVelibProject.*;

class testSetUp {
	private MyVelib myVelib;
	private MyVelib myVelib2;
	private User user1;
	private User user2;
	private User user3;
	
	@BeforeEach
	void setUp() throws GeneralException {
		myVelib = new MyVelib(10,10,0.9,0.5,0.5, 10);
		myVelib2 = new MyVelib(11,9,0.9,0.5,0.5, 10);
		user1 = new User("John",new Coordinates(0, 0), "Vlibre", 100);
		user2 = new User("Artur",new Coordinates(0, 0), "Vmax",100);
		user3 = new User("Paul",new Coordinates(0, 0), null, 100);
		myVelib.addUser(user1);
		myVelib.addUser(user2);
		myVelib.addUser(user3);
		myVelib2.addUser(user1);
		myVelib2.addUser(user2);
		myVelib2.addUser(user3);
	}

	@Test
	void testNumberOfBicycle() {
		ArrayList<Bicycle> bicycleList = myVelib.getBicycleList();
		assertEquals(bicycleList.size(), Math.round(10*10*0.9));
	}
	
	@Test
	void testNumberOfStations() {
		ArrayList<DockingStation> stationList = myVelib.getStationList();
		assertEquals(stationList.size(), Math.round(10));
	}
	
	@Test
	void testNumberOfUsers() {
		ArrayList<User> userList = myVelib.getUserList();
		assertEquals(userList.size(), Math.round(3));
	}

	@Test
	void testTypeOfBicycles() {
		//Test non passé avec les arrondis on a parfois 1 vélo d'écart puisque le pourcentage donne pas un nombre de vélo entier
		ArrayList<Bicycle> bicycleList = myVelib2.getBicycleList();
		int mecanicalCounter = 0;
		int electricalCounter = 0;
		for (Bicycle bicycle : bicycleList) {
			if(bicycle.getType() == "mecanical") {mecanicalCounter++;}
			if(bicycle.getType() == "electrical") {electricalCounter++;}
		}
		assertEquals(mecanicalCounter,Math.round(11*9*0.9*0.5));
		assertEquals(electricalCounter,Math.round(11*9*0.9*0.5));
	}
	@Test
	void testTypeOfStations() {
		//Test non passé avec les arrondis on a parfois 1 station d'écart puisque le pourcentage donne pas un nombre de station entier
		ArrayList<DockingStation> stationList = myVelib2.getStationList();
		int plusCounter = 0;
		for (DockingStation station : stationList) {
			if(station.getType() == "plus") {plusCounter++;}
		}
		assertEquals(plusCounter,Math.round(11*0.5));
	}



}
