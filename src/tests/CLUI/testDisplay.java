package tests.CLUI;

import system.CLUI.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the display command.
 */
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

