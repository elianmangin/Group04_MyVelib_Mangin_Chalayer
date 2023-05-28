package tests.CLUI;

import system.CLUI.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the displayUser command.
 */
public class testDisplayUser {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void test() {
		MyVelibCommands command = new MyVelibCommands("displayUser", new ArrayList<String>(Arrays.asList("1")));
		command.eval();
		// Visual checking by launching this test alone.
		
	}

}

