package com.tecacet.math.fsm;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlphabetTest {

	@Test
	public void testAlphabet() {
		Alphabet<Character> alphabet = new Alphabet<Character>(new Character[]{'a','b'});
		assertEquals(2, alphabet.getSymbolSet().size());
		assertFalse(alphabet.contains('g'));
		assertTrue(alphabet.contains('b'));
	}

}
