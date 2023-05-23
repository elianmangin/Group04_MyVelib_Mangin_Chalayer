package myVelibProject.tests;

import myVelibProject.CreditCard;
import myVelibProject.system.core.Coordinates;
import myVelibProject.system.core.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestUser {
	private User u;
	private CreditCard cc;
	
	@BeforeEach
	void setUp() {
		u = new User("Axel", new Coordinates(42.367, 5.89), "VLibre", cc);
	}

	@Test
	void testAddTimeCredit() {
		assertEquals(u.getTimeCredit(), 0);
		u.addTimeCredit(6);
		assertEquals(u.getTimeCredit(), 6);
		u.addTimeCredit(12);
		assertEquals(u.getTimeCredit(), 18);
	}

}
