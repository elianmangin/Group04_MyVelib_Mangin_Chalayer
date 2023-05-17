package myVelibProject;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testRentOfABike {
	
	@Test
	void test() throws GeneralException {
		MyVelib myVelib = new MyVelib(10,10,0.9,0.5,0.5);
		Renter renter = new Renter(myVelib);
		User user1 = new User("John",new Coordinates(0, 0), "vLibre",new CreditCard(100));
		User user2 = new User("Artur",new Coordinates(0, 0), "vMax",new CreditCard(100));
		User user3 = new User("Paul",new Coordinates(0, 0), null,new CreditCard(100));
		myVelib.addUser(user1);
		myVelib.addUser(user2);
		myVelib.addUser(user3);
		ArrayList<DockingStation> stationList = myVelib.getStationList();
		DockingStation dockingStation1 = stationList.get(0);
		ParkingSlot parkingSlot1 = dockingStation1.getParkingSlotList().get(0);
		Bicycle bicycle1 = parkingSlot1.getParkedBicycle();
		renter.rentBicycle(user3, dockingStation1.getCoordinatesStation(), LocalTime.of(4,45), dockingStation1, parkingSlot1, bicycle1);
		
		DockingStation dockingStation2 = stationList.get(1);
		ParkingSlot parkingSlot2 = null;
		for (ParkingSlot parkingSlot : dockingStation2.getParkingSlotList()) {
			if (!parkingSlot.isOccupied()) {
				parkingSlot2=parkingSlot;
				break;
			}
		}
		renter.returnBicycle(user3, dockingStation2.getCoordinatesStation(), LocalTime.of(6,48), dockingStation2, parkingSlot2, bicycle1);
		
	}
	}


