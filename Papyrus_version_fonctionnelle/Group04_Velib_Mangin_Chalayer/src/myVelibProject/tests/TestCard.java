package myVelibProject.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myVelibProject.system.core.*;

class TestCard {
	Card card;
	User user;
	
	@BeforeEach
	void setUp() throws GeneralException {
		user = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		card = new Card(user);
	}
	@Test
	void testSettersGetters() throws GeneralException {
		//test the getters and setters
		assertEquals(card.getBalance(),0);
		card.addCredit(10);
		assertEquals(card.getBalance(),10);
		card.removeCredit(5);
		assertEquals(card.getBalance(),5);
		assertEquals(card.getUser(),user);
		assertEquals(card.getType(), null);
		card = new Card(user,"Vlibre");
		assertEquals(card.getType(), "Vlibre");
		card = new Card(user,"Vmax");
		assertEquals(card.getType(), "Vmax");
	}
	
	@Test
	void testException() throws GeneralException {
		//test if an exception is thrown when you try to add or remove money the wrong way
		assertEquals(card.getBalance(),0);
		card.addCredit(10);
		Exception exception1 = assertThrows(GeneralException.class, () -> {
			card.addCredit(-5);
		});
		Exception exception2 = assertThrows(GeneralException.class, () -> {
			card.removeCredit(-5);
		});
		Exception exception3 = assertThrows(GeneralException.class, () -> {
			card.removeCredit(15);
		});
		
	}

}
