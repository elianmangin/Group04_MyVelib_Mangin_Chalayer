package Group04_MyVelib_Mangin_Chalayer.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import Group04_MyVelib_Mangin_Chalayer.system.core.*;

public class TestDockingStation {
	private DockingStation S;
	
	
	@Test
	
	void testGetters() {
		//test the getter of the DokcingStation Class
		S = new DockingStation(new Coordinates(1,1), "plus", 2);
		assertTrue(S.getGps().equals(new Coordinates(1,1)));
		assertEquals(S.getNumberOfSlots(), 2);
		assertEquals(S.getType(), "plus");
		
		
		
	}
	@Test
	void testAddBicycle() throws GeneralException {
		// Checking the correct implementation of all the parameters when a bicycle is added
		S = new DockingStation(new Coordinates(1,1), null, 2);
		
		assertEquals(S.getNumberOfSlotsOccupied(), 0);
		assertEquals(S.getNumberOfSlots(), 2);
		Bicycle b1 = new Bicycle(new Coordinates(2,4), "mecanical");
		S.addBicycle(b1);
		assertEquals(S.getNumberOfSlotsOccupied(), 1);
		assertEquals(S.getNumberOfMecanicalBicycle(), 1);
		assertEquals(S.getNumberOfElectricalBicycle(), 0);
		assertEquals(S.getParkingSlotList().get(0).getParkedBicycle(),b1 );
		assertEquals(S.getParkingSlotList().get(0).getParkedBicycle().getGps(), S.getGps());
		assertFalse(S.getParkingSlotList().get(0).getParkedBicycle().isCurrentlyRentedBicycle());
		
		Bicycle b2 = new Bicycle(new Coordinates(3,7), "electrical");
		S.addBicycle(b2);
		assertEquals(S.getNumberOfSlotsOccupied(), 2);
		assertEquals(S.getNumberOfMecanicalBicycle(), 1);
		assertEquals(S.getNumberOfElectricalBicycle(), 1);
		assertEquals(S.getParkingSlotList().get(1).getParkedBicycle().getGps(), S.getGps());
		assertFalse(S.getParkingSlotList().get(1).getParkedBicycle().isCurrentlyRentedBicycle());
		assertEquals(S.getParkingSlotList().get(1).getParkedBicycle(),b2 );
		
		
		assertThrows(Exception.class, () -> {
			S.addBicycle(new Bicycle(new Coordinates(3,7), "electrical"));
		});
	}
	
	
	@Test
	void testTakeBicycle() throws GeneralException {
		// Checking the correct implementation of all the parameters when a bicycle is taken
		S = new DockingStation(new Coordinates(1,1), null, 2);
	
		assertThrows(Exception.class, () -> {
			S.takeBicycle("mecanical");
		});
		assertThrows(Exception.class, () -> {
			S.takeBicycle("electrical");
		});
		
		Bicycle b1 = new Bicycle(new Coordinates(2,4), "mecanical");
		S.addBicycle(b1);
		
		assertThrows(Exception.class, () -> {
			S.takeBicycle("electrical");
		});
		
		Bicycle btaken = S.takeBicycle("mecanical");
		assertEquals(b1, btaken);
		assertEquals(S.getNumberOfSlotsOccupied(), 0);
		
		Bicycle b2 = new Bicycle(new Coordinates(3,7), "electrical");
		S.addBicycle(b2);
		
		assertThrows(Exception.class, () -> {
			S.takeBicycle("mecanical");
		});
		
		btaken = S.takeBicycle("electrical");
		assertEquals(b2, btaken);
		assertEquals(S.getNumberOfSlotsOccupied(), 0);
		
		S.addBicycle(b1);
		S.addBicycle(b2);
		
		assertEquals(S.getNumberOfSlotsOccupied(), 2);
		btaken = S.takeBicycle("electrical");
		assertEquals(b2, btaken);
		assertEquals(S.getNumberOfSlotsOccupied(), 1);
		btaken = S.takeBicycle("mecanical");
		assertEquals(b1, btaken);
		assertEquals(S.getNumberOfSlotsOccupied(), 0);
		
	}

}
