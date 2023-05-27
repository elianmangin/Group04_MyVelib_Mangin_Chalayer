package Group04_MyVelib_Mangin_Chalayer.tests.CLUI;

import Group04_MyVelib_Mangin_Chalayer.system.CLUI.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testDisplayStation {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test() {
		MyVelibCommands command = new MyVelibCommands("displayStation", new ArrayList<String>(Arrays.asList("1")));
		command.eval();
		// Visual checking by launching this test alone.
		
	}

}

