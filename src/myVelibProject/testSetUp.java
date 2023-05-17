package myVelibProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testSetUp {

	@Test
	void testNumberOfBicycle() {
		MyVelib myVelib = new MyVelib(10,10,0.9,0.5,0.5);
		User user1 = new User("John",new Coordinates(0, 0), "vLibre",new CreditCard(100));
		User user2 = new User("Artur",new Coordinates(0, 0), "vMax",new CreditCard(100));
		User user3 = new User("Paul",new Coordinates(0, 0), null,new CreditCard(100));
		myVelib.addUser(user1);
		myVelib.addUser(user2);
		myVelib.addUser(user3);
		ArrayList<Bicycle> bicycleList = myVelib.getBicycleList();
		assertEquals(bicycleList.size(), Math.round(10*10*0.9));
	}
		@Test
		void testNumberOfStations() {
			MyVelib myVelib = new MyVelib(10,10,0.9,0.5,0.5);
			User user1 = new User("John",new Coordinates(0, 0), "vLibre",new CreditCard(100));
			User user2 = new User("Artur",new Coordinates(0, 0), "vMax",new CreditCard(100));
			User user3 = new User("Paul",new Coordinates(0, 0), null,new CreditCard(100));
			myVelib.addUser(user1);
			myVelib.addUser(user2);
			myVelib.addUser(user3);
			ArrayList<DockingStation> stationList = myVelib.getStationList();
			assertEquals(stationList.size(), Math.round(10));
		}
		@Test
		void testNumberOfUsers() {
			MyVelib myVelib = new MyVelib(10,10,0.9,0.5,0.5);
			User user1 = new User("John",new Coordinates(0, 0), "vLibre",new CreditCard(100));
			User user2 = new User("Artur",new Coordinates(0, 0), "vMax",new CreditCard(100));
			User user3 = new User("Paul",new Coordinates(0, 0), null,new CreditCard(100));
			myVelib.addUser(user1);
			myVelib.addUser(user2);
			myVelib.addUser(user3);
			ArrayList<User> userList = myVelib.getUserList();
			assertEquals(userList.size(), Math.round(3));
		}
		
		@Test
		void testTypeOfBicycles() {
			//Test non passé avec les arrondis on a parfois 1 vélo d'écart puisque le pourcentage donne pas un nombre de vélo entier
			MyVelib myVelib = new MyVelib(11,9,0.9,0.5,0.5);
			User user1 = new User("John",new Coordinates(0, 0), "vLibre",new CreditCard(100));
			User user2 = new User("Artur",new Coordinates(0, 0), "vMax",new CreditCard(100));
			User user3 = new User("Paul",new Coordinates(0, 0), null,new CreditCard(100));
			myVelib.addUser(user1);
			myVelib.addUser(user2);
			myVelib.addUser(user3);
			ArrayList<Bicycle> bicycleList = myVelib.getBicycleList();
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
			MyVelib myVelib = new MyVelib(11,9,0.9,0.5,0.5);
			User user1 = new User("John",new Coordinates(0, 0), "vLibre",new CreditCard(100));
			User user2 = new User("Artur",new Coordinates(0, 0), "vMax",new CreditCard(100));
			User user3 = new User("Paul",new Coordinates(0, 0), null,new CreditCard(100));
			myVelib.addUser(user1);
			myVelib.addUser(user2);
			myVelib.addUser(user3);
			ArrayList<DockingStation> stationList = myVelib.getStationList();
			int plusCounter = 0;
			for (DockingStation station : stationList) {
				if(station.getType() == "plus") {plusCounter++;}
			}
			assertEquals(plusCounter,Math.round(11*0.5));
		}
		
		

}
