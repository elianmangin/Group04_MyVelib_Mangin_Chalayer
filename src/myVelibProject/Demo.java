package myVelibProject;

import java.time.LocalTime;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		//Création du système et du renter
		MyVelib myVelib = new MyVelib();
		Renter renter = new Renter(myVelib);
		//Création des utilisateurs
		User user1 = new User("John",new Coordinates(0, 0), "vLibre",new CreditCard());
		myVelib.addUser(user1);
		System.out.print(user1);
		//Création des DockingStation
		ParkingSlot parkingSlot1 = new ParkingSlot();
		ParkingSlot parkingSlot2 = new ParkingSlot();
		ArrayList<ParkingSlot> parkingSlotList = new ArrayList<ParkingSlot>();
		parkingSlotList.add(parkingSlot1);
		parkingSlotList.add(parkingSlot2);
		DockingStationBalance dockingStationBalance1 = new DockingStationBalance();
		DockingStation dockingStation1 = new DockingStation(new Coordinates(0, 0),"online","plus",2,parkingSlotList,dockingStationBalance1);
		System.out.print("\n" +dockingStation1);
		//Création des bicycles
		Bicycle bicycle1 = new Bicycle(new Coordinates(10, 10), "mecanical");
		
		//Trajet
		renter.rentBicycle(user1, new Coordinates(10, 10), LocalTime.of(5,15), null, null, bicycle1);
		renter.returnBicycle(user1, new Coordinates(0, 0), LocalTime.of(6,45), dockingStation1, parkingSlot1, bicycle1);
	}

}
