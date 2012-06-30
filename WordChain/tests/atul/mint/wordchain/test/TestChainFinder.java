package atul.mint.wordchain.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import atul.mint.wordchain.ChainFinder;

public class TestChainFinder {

	@Test
	public void testGetAllSimilarWords() 
	{
		ChainFinder finder = new ChainFinder();
		HashMap<String, String> similarWords = finder.getAllSimilarWords("bar");
		
		assertTrue(similarWords.containsKey("bat"));
		assertTrue(similarWords.containsKey("bay"));
		assertTrue(similarWords.containsKey("tar"));
		assertTrue(similarWords.containsKey("tat"));
		
	}
	
	@Test
	public void testShortestWordChainBetween()
	{
		ChainFinder finder = new ChainFinder();
		ArrayList<String> result = finder.shortestWordChainBetween("bar", "fat");
		assertTrue(result.contains("bat"));
		assertTrue(result.size() == 3);
	}

}
