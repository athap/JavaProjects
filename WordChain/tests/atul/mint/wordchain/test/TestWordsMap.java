package atul.mint.wordchain.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import atul.mint.wordchain.MapWords;

public class TestWordsMap {

	@Test
	public void testDifferByOne() 
	{
		MapWords wordsMap = new MapWords("files/dictionary.txt");
		
		assertTrue(wordsMap.differByOne("mint", "mind"));
		assertTrue(wordsMap.differByOne("mind", "mint"));
		assertTrue(wordsMap.differByOne("dog", "dot"));
		
		assertFalse(wordsMap.differByOne("abcdef", "abcdef"));
		assertFalse(wordsMap.differByOne("abcdef", "abc"));
		assertFalse(wordsMap.differByOne("abcdef", "abcde "));
		assertFalse(wordsMap.differByOne("  ", "a "));
	}

	@Test
	public void testBuildAndReturnMap()
	{
		MapWords wordsMap = new MapWords("files/dictionary.txt");
		HashMap<String, ArrayList<String>> map = wordsMap.buildAndReturnMap();
		
		for(String word : map.keySet())
		{
			ArrayList<String> similarWords = map.get(word);
			
			for(String similar : similarWords)
				assertTrue(wordsMap.differByOne(word, similar));
		}		
	}

}
