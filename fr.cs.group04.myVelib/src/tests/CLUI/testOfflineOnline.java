package tests.CLUI;

import system.CLUI.*;
import system.core.GeneralException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the online and offline command.
 */
public class testOfflineOnline {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test1() throws GeneralException {
		assertEquals("online", MyVelibSystem.myVelib.getStationFromID(1).getStatus());
		
		MyVelibCommands command = new MyVelibCommands("offline", new ArrayList<String>(Arrays.asList("1")));
		command.eval();
		assertEquals("offline", MyVelibSystem.myVelib.getStationFromID(1).getStatus());
		
		command = new MyVelibCommands("online", new ArrayList<String>(Arrays.asList("1")));
		command.eval();
		assertEquals("online", MyVelibSystem.myVelib.getStationFromID(1).getStatus());
	
		
	}
	
	@Test
	void test2() throws GeneralException {
		assertEquals("online", MyVelibSystem.myVelib.getStationFromID(4).getStatus());
		
		MyVelibCommands command = new MyVelibCommands("online", new ArrayList<String>(Arrays.asList("4")));
		command.eval();
		assertEquals("online", MyVelibSystem.myVelib.getStationFromID(4).getStatus());
		
		command = new MyVelibCommands("offline", new ArrayList<String>(Arrays.asList("4")));
		command.eval();
		assertEquals("offline", MyVelibSystem.myVelib.getStationFromID(4).getStatus());
	
		
	}
	

}

