package Testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import Control.Card;

class CardTesting {

	Card card = new Card();

	@Test
	void test1() {
		int v = 9;
		card.setValue(v);
		assertEquals(9, card.getValue());
	}

	@Test
	void test2() {
		String number = "8";
		card.setNumber(number);
		Assert.assertTrue(card.getNumber().equals("8"));
	}

	@Test
	void test3() {
		// setting setters and getters for type
		String type = "diamonds";
		card.setType(type);
		Assert.assertTrue(card.getType().equals("diamonds"));
	}
}
