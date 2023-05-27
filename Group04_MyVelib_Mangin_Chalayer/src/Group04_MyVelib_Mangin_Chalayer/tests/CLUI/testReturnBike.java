package Group04_MyVelib_Mangin_Chalayer.tests.CLUI;

import Group04_MyVelib_Mangin_Chalayer.system.CLUI.*;
import Group04_MyVelib_Mangin_Chalayer.system.core.GeneralException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testReturnBike {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test1() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("1", "1")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("1", "1", "mecanical")));
		command.eval();
		
		int nBikeS = MyVelibSystem.myVelib.getStationFromID(7).getNumberOfMecanicalBicycle();
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("1", "7", "210")));
		command.eval();
		
		assertFalse(MyVelibSystem.myVelib.getUserFromID(1).isCurrentlyRenting());
		assertEquals(nBikeS + 1 , MyVelibSystem.myVelib.getStationFromID(7).getNumberOfMecanicalBicycle());
		
		
	}
	
	@Test
	void test2() throws GeneralException {
		MyVelibCommands command = new MyVelibCommands("moveUserToStation", new ArrayList<String>(Arrays.asList("2", "1")));
		command.eval();
		
		command = new MyVelibCommands("rentBike", new ArrayList<String>(Arrays.asList("2", "1", "mecanical")));
		command.eval();
		
		command = new MyVelibCommands("moveUserToCoord", new ArrayList<String>(Arrays.asList("1", "5", "5")));
		command.eval();
		
		command = new MyVelibCommands("returnBike", new ArrayList<String>(Arrays.asList("2", "5", "5", "210")));
		command.eval();
		
		
		assertFalse(MyVelibSystem.myVelib.getUserFromID(2).isCurrentlyRenting());
		
	}

}

