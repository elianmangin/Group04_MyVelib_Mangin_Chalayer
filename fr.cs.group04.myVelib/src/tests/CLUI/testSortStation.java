package tests.CLUI;

import system.CLUI.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the sortStation command.
 */
public class testSortStation {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
		
		// Moving all the bicycle from station 7 to station 2 --> test least occupied station
		
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "7")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "7", "mecanical")));
		command.eval();
		
		command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "2")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "2", "210")));
		command.eval();
		
		command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "7")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "7", "mecanical")));
		command.eval();
		
		command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "2")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "2", "210")));
		command.eval();
		
		command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "7")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "7", "electrical")));
		command.eval();
		
		command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "3")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "3", "210")));
		command.eval();
		
		// Compute a lot of operation on station 5 --> test most used
		
		command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "5")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "5", "mecanical")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "5", "210")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "5", "mecanical")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "5", "210")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "5", "mecanical")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "5", "210")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "5", "mecanical")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "5", "210")));
		command.eval();
		
		
	}

	@Test
	void testMostUsed() {
		MyVelibCommands command = new MyVelibCommands("sortStation", new ArrayList<String>(Arrays.asList("mostUsed")));
		command.eval();
		
		command = new MyVelibCommands("display", new ArrayList<String>());
		command.eval();
		
		assertEquals(5, MyVelibSystem.myVelib.getStationList().get(0).getUniqID());
		assertEquals(7, MyVelibSystem.myVelib.getStationList().get(1).getUniqID());
		assertEquals(2, MyVelibSystem.myVelib.getStationList().get(2).getUniqID());
		assertEquals(3, MyVelibSystem.myVelib.getStationList().get(3).getUniqID());
		
		
		
		
		
	}
	
	@Test
	void testLeastOccupied() {
		MyVelibCommands command = new MyVelibCommands("sortStation", new ArrayList<String>(Arrays.asList("leastOccupied")));
		command.eval();
		
		command = new MyVelibCommands("display", new ArrayList<String>());
		command.eval();
		
		assertEquals(7, MyVelibSystem.myVelib.getStationList().get(0).getUniqID());
		assertEquals(3, MyVelibSystem.myVelib.getStationList().get(8).getUniqID());
		assertEquals(2, MyVelibSystem.myVelib.getStationList().get(9).getUniqID());
		
		
		
	}
	
	@Test
	void testID() {
		MyVelibCommands command = new MyVelibCommands("sortStation", new ArrayList<String>(Arrays.asList("mostUsed")));
		command.eval();
		
		command = new MyVelibCommands("sortStation", new ArrayList<String>(Arrays.asList("ID")));
		command.eval();
		
		command = new MyVelibCommands("display", new ArrayList<String>());
		command.eval();
		
		for (int i = 1 ; i<11 ; i++) {
			assertEquals(i, MyVelibSystem.myVelib.getStationList().get(i-1).getUniqID());
		}
		
		
		
	}

}

