package tests.CLUI;

import system.CLUI.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the setup command.
 */
public class testSetup {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void testBasicSetup() {
		MyVelibCommands command = new MyVelibCommands("setup", new ArrayList<String>());
		command.eval();
		
		assertEquals(10, MyVelibSystem.myVelib.getStationList().size());
		assertEquals(10, MyVelibSystem.myVelib.getStationList().get(0).getParkingSlotList().size());
		assertEquals(75, MyVelibSystem.myVelib.getBicycleList().size());
		assertEquals(0, MyVelibSystem.myVelib.getUserList().size());
		
	}
	
	@Test
	void testParameterSetup() {
		MyVelibCommands command = new MyVelibCommands("setup", new ArrayList<String>(Arrays.asList("5", "3", "5", "13")));
		command.eval();
		
		assertEquals(5, MyVelibSystem.myVelib.getStationList().size());
		assertEquals(3, MyVelibSystem.myVelib.getStationList().get(0).getParkingSlotList().size());
		assertEquals(13, MyVelibSystem.myVelib.getBicycleList().size());
		assertEquals(0, MyVelibSystem.myVelib.getUserList().size());
		
	}

}
