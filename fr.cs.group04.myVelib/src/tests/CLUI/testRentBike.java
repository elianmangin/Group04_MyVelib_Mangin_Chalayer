package tests.CLUI;

import system.CLUI.*;
import system.core.GeneralException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the rentBike command.
 */
class testRentBike {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test1() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "1")));
		command.eval();
		
		int nBikeS = MyVelibSystem.myVelib.getStationFromID(1).getNumberOfMecanicalBicycle();
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "1", "mecanical")));
		command.eval();
		
		assertTrue(MyVelibSystem.myVelib.getUserFromID(1).isCurrentlyRenting());
		assertEquals("mecanical", MyVelibSystem.myVelib.getUserFromID(1).getCurrentRide().getBicycleUsed().getType());
		assertEquals(nBikeS - 1 , MyVelibSystem.myVelib.getStationFromID(1).getNumberOfMecanicalBicycle());
		
	}
	
	@Test
	void test2() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("2", "7")));
		command.eval();
		
		int nBikeS = MyVelibSystem.myVelib.getStationFromID(7).getNumberOfElectricalBicycle();
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("2", "7", "electrical")));
		command.eval();
		
		assertTrue(MyVelibSystem.myVelib.getUserFromID(2).isCurrentlyRenting());
		assertEquals("electrical", MyVelibSystem.myVelib.getUserFromID(2).getCurrentRide().getBicycleUsed().getType());
		assertEquals(nBikeS - 1 , MyVelibSystem.myVelib.getStationFromID(7).getNumberOfElectricalBicycle());
		
	}
	
	@Test
	void testImpossible() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("3", "1")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("3", "1", "electrical")));
		command.eval();
		
		assertFalse(MyVelibSystem.myVelib.getUserFromID(2).isCurrentlyRenting());
		
	}
	
	@Test
	void test3() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "1")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "1", "mecanical")));
		command.eval();
		
		command = new MyVelibCommands("moveUserToCoord", new ArrayList<String>(Arrays.asList("1", "5", "5")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "5", "5", "210")));
		command.eval();
		
		command = new MyVelibCommands("moveUserToCoord", new ArrayList<String>(Arrays.asList("2", "5", "5")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("2", "1")));
		command.eval();
		
		assertTrue(MyVelibSystem.myVelib.getUserFromID(2).isCurrentlyRenting());
		assertEquals("mecanical", MyVelibSystem.myVelib.getUserFromID(2).getCurrentRide().getBicycleUsed().getType());
		
	}
	
	

}

