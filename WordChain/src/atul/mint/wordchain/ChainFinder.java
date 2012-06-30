package atul.mint.wordchain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @class - ChainFinder
 * 
 * @brief - This class is responsible for finding the shortest chain between 2 words
 * 
 * @author atul
 *
 */
public class ChainFinder 
{
	/**
	 * Initialize the maps and builds the map of words
	 */
	public ChainFinder()
	{
		init();
	}
	
	/**
	 * Finds the minimum chain of words required to get to the second word from firstword 
	 * 
	 * @param firstWord
	 * @param secondWord
	 * 
	 * @return list of words
	 */
	public ArrayList<String> shortestWordChainBetween(String firstWord, String secondWord)
	{
		if(firstWord == null || secondWord == null)
			return null;
		
		if(firstWord.length() != secondWord.length())
			return null;
		
		HashMap<String, String> listOfSimilarWords = getAllSimilarWords(firstWord);
		
		return getShortestChain(firstWord, secondWord, listOfSimilarWords);
	}
	
	/**
	 * Returns a map of words which differ by one character to 
	 * (1) firstword
	 * (2) all words which differ by one from firstword
	 * 
	 * @param firstWord
	 * @return map of words
	 */
	public HashMap<String, String> getAllSimilarWords(String firstWord)
	{
		HashMap<String, String> mListOfWords = new HashMap<String, String>();
		Queue<String> queue = new LinkedList<String>();
		
		queue.add(firstWord);
		
		while(!queue.isEmpty())
		{
			String word = queue.poll();
			if(mMap.containsKey(word))
			{
				for (String similar : mMap.get(word)) 
				{
					if(!mListOfWords.containsKey(similar))
					{
						mListOfWords.put(similar, word);
						queue.add(similar);
					}
				}
			}
		}
		
		return mListOfWords;
	}
	
	/**
	 * 
	 * Returns the shortest chain of words
	 * 
	 * @param similarWords
	 * @return
	 */
	private ArrayList<String> getShortestChain(String firstWord, 
			String secondWord , HashMap<String, String> similarWords)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		if(!similarWords.containsKey(secondWord))
			return null;
		
		String currentWord = secondWord;		
		
		while(!currentWord.equals(firstWord) && similarWords.containsKey(currentWord))
		{
			result.add(currentWord);
			currentWord = similarWords.get(currentWord);
		}
		
		result.add(firstWord);
		return result;
	}
	
	/**
	 * 
	 */
	private void init()
	{
		// hard coding the path to dictionary. This is the list provided by Ubuntu
		mMapWords = new MapWords("files/dictionary.txt");
		mMap = mMapWords.buildAndReturnMap();
	}
	
	//
	private MapWords mMapWords;
	
	private HashMap<String, ArrayList<String>> mMap; 
}
