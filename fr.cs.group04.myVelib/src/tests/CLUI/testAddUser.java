package tests.CLUI;

import system.CLUI.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Several tests to test the addUser command.
 */
class testAddUser {
	@BeforeEach
	void setUp() {
		MyVelibSystem.startProcess();
	}

	@Test
	void testName() {
		assertEquals(3, MyVelibSystem.myVelib.getUserList().size());
		
		MyVelibCommands command = new MyVelibCommands("addUser", new ArrayList<String>(Arrays.asList("Axel", "none", "100", "0", "1")));
		command.eval();
		assertEquals(4, MyVelibSystem.myVelib.getUserList().size());
		assertEquals("Axel", MyVelibSystem.myVelib.getUserList().get(3).getName());
		
		command = new MyVelibCommands("addUser", new ArrayList<String>(Arrays.asList("Bob", "Vlibre", "100", "0", "1")));
		command.eval();
		assertEquals(5, MyVelibSystem.myVelib.getUserList().size());
		assertEquals("Bob", MyVelibSystem.myVelib.getUserList().get(4).getName());
		
		command = new MyVelibCommands("addUser", new ArrayList<String>(Arrays.asList("Alice", "Vmax", "100", "0", "1")));
		command.eval();
		assertEquals(6, MyVelibSystem.myVelib.getUserList().size());
		assertEquals("Alice", MyVelibSystem.myVelib.getUserList().get(5).getName());
		
		
	}
	
	@Test
	void testFirstNameLastName() {
		assertEquals(3, MyVelibSystem.myVelib.getUserList().size());
		
		MyVelibCommands command = new MyVelibCommands("addUser", new ArrayList<String>(Arrays.asList("Axel", "Chalayer", "none", "100", "0", "1")));
		command.eval();
		assertEquals(4, MyVelibSystem.myVelib.getUserList().size());
		assertEquals("Axel Chalayer", MyVelibSystem.myVelib.getUserList().get(3).getName());
		
		command = new MyVelibCommands("addUser", new ArrayList<String>(Arrays.asList("Bob", "Dalton", "Vlibre", "100", "0", "1")));
		command.eval();
		assertEquals(5, MyVelibSystem.myVelib.getUserList().size());
		assertEquals("Bob Dalton", MyVelibSystem.myVelib.getUserList().get(4).getName());
		
		command = new MyVelibCommands("addUser", new ArrayList<String>(Arrays.asList("Alice", "Wonderland", "Vmax", "100", "0", "1")));
		command.eval();
		assertEquals(6, MyVelibSystem.myVelib.getUserList().size());
		assertEquals("Alice Wonderland", MyVelibSystem.myVelib.getUserList().get(5).getName());
		
	}

}

