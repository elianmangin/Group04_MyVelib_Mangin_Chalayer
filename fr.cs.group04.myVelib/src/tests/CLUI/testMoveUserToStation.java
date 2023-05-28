package tests.CLUI;

import system.CLUI.*;
import system.core.GeneralException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the moveUserToStation command.
 */
public class testMoveUserToStation {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test1() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "3")));
		command.eval();
		
		assertEquals(MyVelibSystem.myVelib.getStationFromID(3).getGps(), MyVelibSystem.myVelib.getUserFromID(1).getGps());
		
	}
	
	@Test
	void test2() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("2", "1")));
		command.eval();
		
		assertEquals(MyVelibSystem.myVelib.getStationFromID(1).getGps(), MyVelibSystem.myVelib.getUserFromID(2).getGps());
		
	}
	
	@Test
	void test3() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("3", "5")));
		command.eval();
		
		assertEquals(MyVelibSystem.myVelib.getStationFromID(5).getGps(), MyVelibSystem.myVelib.getUserFromID(3).getGps());
		
	}
	
	@Test
	void test4() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "9")));
		command.eval();
		
		assertEquals(MyVelibSystem.myVelib.getStationFromID(9).getGps(), MyVelibSystem.myVelib.getUserFromID(1).getGps());
		
	}

}

