package com.tecacet.math.fsm;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterAlphabetTest {

	@Test
	public void testAlphabet() {
		CharacterAlphabet alphabet = new CharacterAlphabet(new char[] { 'a',
				'b' });
		assertEquals(2, alphabet.getSymbolSet().size());
		assertFalse(alphabet.contains('g'));
		assertTrue(alphabet.contains('b'));
		alphabet.addSymbol('c');
		assertEquals(3, alphabet.getSymbols().length);
	}

}
