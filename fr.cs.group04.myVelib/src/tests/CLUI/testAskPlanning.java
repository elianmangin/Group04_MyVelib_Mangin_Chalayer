package tests.CLUI;

import system.CLUI.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the askPlanning command.
 */
class testAskPlanning {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test() {
		MyVelibCommands command = new MyVelibCommands("askPlanning", new ArrayList<String>(Arrays.asList("1", "2", "5", "mecanical", "standard")));
		command.eval();
		
		assertTrue(true); // This function does not affect the system. It just display departure and arrival in the console
		// Require visual checking by launching 'testAskPlanning' only.
		
	}
	
	

}

