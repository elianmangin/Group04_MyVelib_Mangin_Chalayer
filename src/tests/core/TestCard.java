package tests.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import system.core.*;

/**
 * Junit test of the Card methods
 * @see Card
 */
public class TestCard {
	Card card;
	User user;
	
	@BeforeEach
	void setUp() throws GeneralException {
		user = new User("Jean", new Coordinates(1.234,1.546), "Vlibre", 100);
		card = new Card(user);
	}
	
	
	/**test the getters and setters*/
	@Test
	public void testSettersGetters() throws GeneralException {
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
	
	
	/**test if an exception is thrown when you try to add or remove money the wrong way*/
	@Test
	public void testException() throws GeneralException {
		assertEquals(card.getBalance(),0);
		card.addCredit(10);
		assertThrows(GeneralException.class, () -> {
			card.addCredit(-5);
		});
		assertThrows(GeneralException.class, () -> {
			card.removeCredit(-5);
		});
		assertThrows(GeneralException.class, () -> {
			card.removeCredit(15);
		});
		
	}

}
