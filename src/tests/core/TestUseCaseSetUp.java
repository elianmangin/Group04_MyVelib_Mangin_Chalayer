package tests.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import system.core.*;

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
	/** test the numbers of bicycles in the system*/
	void testNumberOfBicycle() {
		ArrayList<Bicycle> bicycleList = myVelib.getBicycleList();
		assertEquals(bicycleList.size(), Math.round(10*10*0.9));
	}
	
	@Test
	/** test the numbers of station in the system*/
	void testNumberOfStations() {
		ArrayList<DockingStation> stationList = myVelib.getStationList();
		assertEquals(stationList.size(), Math.round(10));
	}
	
	@Test
	/** test the numbers of users in the system*/
	void testNumberOfUsers() {
		ArrayList<User> userList = myVelib.getUserList();
		assertEquals(userList.size(), Math.round(3));
	}
	
	@Test
	/** test the info of the user in the system*/
	void testInfoOfUsers() {
		ArrayList<User> userList = myVelib.getUserList();
		assertEquals(userList.get(0), user1);
		assertEquals(userList.get(1), user2);
		assertEquals(userList.get(2), user3);	
		}
	
	@Test
	/** test the number of bicycles of a certain type, case where it works*/
	void testTypeOfBicyclesGoodCase() {
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
	/** test the number of bicycles of a certain type, case where it works*/
	void testTypeOfBicyclesBadCase() {
		ArrayList<Bicycle> bicycleList = myVelib2.getBicycleList();
		int mecanicalCounter = 0;
		int electricalCounter = 0;
		for (Bicycle bicycle : bicycleList) {
			if(bicycle.getType() == "mecanical") {mecanicalCounter++;}
			if(bicycle.getType() == "electrical") {electricalCounter++;}
		}
		assertEquals(mecanicalCounter,Math.round(45));
		assertEquals(electricalCounter,Math.round(44));
	}
	
	@Test
	/** test the number of station of a certain type, case where it works */
	void testTypeOfStationsBadCase () {
		ArrayList<DockingStation> stationList = myVelib2.getStationList();
		int plusCounter = 0;
		for (DockingStation station : stationList) {
			if(station.getType() == "plus") {plusCounter++;}
		}
		assertEquals(plusCounter,Math.round(11*0.5));
	}
	
	@Test
	/** test the number of station of a certain type, case where it works*/
	void testTypeOfStationsGoodCase () {
		ArrayList<DockingStation> stationList = myVelib.getStationList();
		int plusCounter = 0;
		for (DockingStation station : stationList) {
			if(station.getType() == "plus") {plusCounter++;}
		}
		assertEquals(plusCounter,Math.round(10*0.5));
	}
	
	@Test
	/** Checking if the stations are in the 10x10 square*/
	void testStationInSquare() {
		for (DockingStation s : myVelib.getStationList()) {
			assertTrue(s.getGps().getX() >= 0 && s.getGps().getX() <= 10);
			assertTrue(s.getGps().getY() >= 0 && s.getGps().getY() <= 10);
		}
	}



}