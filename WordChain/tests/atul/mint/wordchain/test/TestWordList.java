package atul.mint.wordchain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import atul.mint.wordchain.WordList;

public class TestWordList 
{

	@Test
	public void testWords() 
	{
		WordList list = new WordList("files/dictionary.txt");
		
		assertNotNull(list.words());
		assertTrue(list.words().size() > 1);
	}

}
