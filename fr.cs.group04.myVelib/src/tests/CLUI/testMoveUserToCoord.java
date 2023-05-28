package tests.CLUI;

import system.CLUI.*;
import system.core.Coordinates;
import system.core.GeneralException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the moveUserToCoord command.
 */
class testMoveUserToCoord {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test1() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToCoord", new ArrayList<String>(Arrays.asList("1", "3", "2")));
		command.eval();
		
		assertTrue(new Coordinates(3, 2).equals(MyVelibSystem.myVelib.getUserFromID(1).getGps()));
		
	}
	
	@Test
	void test2() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToCoord", new ArrayList<String>(Arrays.asList("2", "1", "2")));
		command.eval();
		
		assertTrue(new Coordinates(1, 2).equals(MyVelibSystem.myVelib.getUserFromID(2).getGps()));
		
	}
	
	@Test
	void test3() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToCoord", new ArrayList<String>(Arrays.asList("3", "5", "9")));
		command.eval();
		
		assertTrue(new Coordinates(5, 9).equals(MyVelibSystem.myVelib.getUserFromID(3).getGps()));
		
	}
	
	@Test
	void test4() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToCoord", new ArrayList<String>(Arrays.asList("1", "7", "5")));
		command.eval();
		
		assertTrue(new Coordinates(7, 5).equals(MyVelibSystem.myVelib.getUserFromID(1).getGps()));
		
	}

}

