package tests.CLUI;

import system.CLUI.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the displayStation command.
 */
public class testDisplayStation {
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

