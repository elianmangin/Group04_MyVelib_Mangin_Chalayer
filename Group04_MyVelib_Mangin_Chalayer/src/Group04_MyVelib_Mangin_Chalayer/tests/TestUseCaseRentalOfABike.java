package Group04_MyVelib_Mangin_Chalayer.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Group04_MyVelib_Mangin_Chalayer.system.core.*;

public class TestUseCaseRentalOfABike {
	private MyVelib myVelib;
	private Renter renter;
	private User user1;
	private User user2;
	private User user3;

	@BeforeEach
	void setUp() throws GeneralException {
		myVelib = new MyVelib(10,10,0.9,0.5,0.5, 10);
		user1 = new User("John",new Coordinates(0, 0), "Vlibre", 100);
		user2 = new User("Artur",new Coordinates(0, 0), "Vmax",100);
		user3 = new User("Paul",new Coordinates(0, 0), null, 100);
		myVelib.addUser(user1);
		myVelib.addUser(user2);
		myVelib.addUser(user3);
		renter = new Renter(myVelib);

	}

	@Test
	void test() throws GeneralException {
		renter.connectUser(user1);
		assertEquals(renter.getUser().getName(), "John");
		renter.askPlanning(new Coordinates(5,6), "mecanical", "standard");
		renter.rentBicycle(LocalTime.of(4, 45));
		renter.returnBicycle(LocalTime.of(6, 48));
	}
}
	
	/*
	@Test
	void test() throws GeneralException {

		ArrayList<DockingStation> stationList = myVelib.getStationList();
		DockingStation dockingStation1 = stationList.get(0);
		ParkingSlot parkingSlot1 = dockingStation1.getParkingSlotList().get(0);
		Bicycle bicycle1 = parkingSlot1.getParkedBicycle();
		renter.rentBicycle(user3, dockingStation1.gGps(), LocalTime.of(4,45), dockingStation1, parkingSlot1, bicycle1);

		DockingStation dockingStation2 = stationList.get(1);
		ParkingSlot parkingSlot2 = null;
		for (ParkingSlot parkingSlot : dockingStation2.getParkingSlotList()) {
			if (!parkingSlot.isOccupied()) {
				parkingSlot2=parkingSlot;
				break;
			}
		}
		renter.returnBicycle(user3, dockingStation2.getGps(), LocalTime.of(6,48), dockingStation2, parkingSlot2, bicycle1);

	}*/
	
