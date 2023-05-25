package Group04_Velib_Mangin_Chalayer.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Group04_Velib_Mangin_Chalayer.system.Bicycle;
import Group04_Velib_Mangin_Chalayer.system.Coordinates;
import Group04_Velib_Mangin_Chalayer.system.DockingStation;
import Group04_Velib_Mangin_Chalayer.system.GeneralException;
import Group04_Velib_Mangin_Chalayer.system.MyVelib;
import Group04_Velib_Mangin_Chalayer.system.User;

public class TestUseCaseSetUp {
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
		//test the numbers of bicycles in the system
		ArrayList<Bicycle> bicycleList = myVelib.getBicycleList();
		assertEquals(bicycleList.size(), Math.round(10*10*0.9));
	}
	
	@Test
	void testNumberOfStations() {
		//test the numbers of station in the system
		ArrayList<DockingStation> stationList = myVelib.getStationList();
		assertEquals(stationList.size(), Math.round(10));
	}
	
	@Test
	void testNumberOfUsers() {
		//test the numbers of users in the system
		ArrayList<User> userList = myVelib.getUserList();
		assertEquals(userList.size(), Math.round(3));
	}
	
	@Test
	void testInfoOfUsers() {
		//test the info of the user in the system
		ArrayList<User> userList = myVelib.getUserList();
		assertEquals(userList.get(0), user1);
		assertEquals(userList.get(1), user2);
		assertEquals(userList.get(2), user3);	
		}
	
	@Test
	void testTypeOfBicyclesGoodCase() {
		//test the number of bicycles of a certain type, case where it works
		ArrayList<Bicycle> bicycleList = myVelib.getBicycleList();
		int mecanicalCounter = 0;
		int electricalCounter = 0;
		for (Bicycle bicycle : bicycleList) {
			if(bicycle.getType() == "mecanical") {mecanicalCounter++;}
			if(bicycle.getType() == "electrical") {electricalCounter++;}
		}
		assertEquals(mecanicalCounter,Math.round(10*10*0.9*0.5));
		assertEquals(electricalCounter,Math.round(10*10*0.9*0.5));
	}
	
	@Test
	void testTypeOfBicyclesBadCase() {
		//test the number of bicycles of a certain type, case where it works
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
	void testTypeOfStationsBadCase () {
		//test the number of station of a certain type, case where it works
		ArrayList<DockingStation> stationList = myVelib2.getStationList();
		int plusCounter = 0;
		for (DockingStation station : stationList) {
			if(station.getType() == "plus") {plusCounter++;}
		}
		assertEquals(plusCounter,Math.round(11*0.5));
	}
	
	@Test
	void testTypeOfStationsGoodCase () {
		//test the number of station of a certain type, case where it works
		ArrayList<DockingStation> stationList = myVelib.getStationList();
		int plusCounter = 0;
		for (DockingStation station : stationList) {
			if(station.getType() == "plus") {plusCounter++;}
		}
		assertEquals(plusCounter,Math.round(10*0.5));
	}
	
	@Test
	void testStationInSquare() {
		// Checking if the stations are in the 10x10 square
		for (DockingStation s : myVelib.getStationList()) {
			assertTrue(s.getGps().getX() >= 0 && s.getGps().getX() <= 10);
			assertTrue(s.getGps().getY() >= 0 && s.getGps().getY() <= 10);
		}
	}



}