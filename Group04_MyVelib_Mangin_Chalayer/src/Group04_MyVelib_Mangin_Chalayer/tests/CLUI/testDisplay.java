package Group04_MyVelib_Mangin_Chalayer.tests.CLUI;

import Group04_MyVelib_Mangin_Chalayer.system.CLUI.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testDisplay {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test() {
		MyVelibCommands command = new MyVelibCommands("display", new ArrayList<String>());
		command.eval();
		// Visual checking by launching this test alone.
		
	}
	

}

