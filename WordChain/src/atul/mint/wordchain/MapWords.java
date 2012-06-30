package atul.mint.wordchain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @class - MapWords
 * 
 * @brief - Creates a map with keys as words and values as a list of words
 *          which are one character apart
 * 
 * @author atul
 *
 */
public class MapWords 
{
	/**
	 * Gets the word list and groups all the words with respect to the length
	 * This will help in getting all the similar words quickly
	 * 
	 * @param pathToWordList - location of dictionary
	 */
	public MapWords(String pathToWordList)
	{
		// Load the word list from the the file
		mWordList = new WordList(pathToWordList);
		
		// groups all the words by their length
		groupWordsByLength();
	}
	
	/**
	 * 
	 * Builds the map with keys as words and values as a list of words 
	 * which differ by one character 
	 * 
	 * @return map
	 */
	public HashMap<String, ArrayList<String>> buildAndReturnMap()
	{
		for(Integer key : mWordGroupByLength.keySet())
		{
			ArrayList<String> groupedWords = mWordGroupByLength.get(key);
			
			for(int i = 0; i < groupedWords.size(); i++)
			{
				for(int j = i; j < groupedWords.size(); j++)
				{
					if(differByOne(groupedWords.get(i), groupedWords.get(j)))
					{
						addToSimilarWords(groupedWords.get(i), groupedWords.get(j));
						addToSimilarWords(groupedWords.get(j), groupedWords.get(i));
					}
				}
			}
		}
		
		return mSimilarWords;
	}
	
	/**
	 * Check whether or not the two words differ by one character
	 * 
	 * @param firstWord
	 * @param secondWord
	 * @return boolean
	 * 
	 * @note Special case like "ab " and "abc" are taken care of
	 */
	public boolean differByOne(String firstWord, String secondWord)
	{
		if(firstWord.length() != secondWord.length())
			return false;
		
		int differBy = 0;
		
		for(int index = 0; index < firstWord.length(); index++)
		{
			if(firstWord.charAt(index) != ' ' &&
					secondWord.charAt(index) != ' ' &&
					firstWord.charAt(index) != secondWord.charAt(index))
				if(differBy++ > 1)
					return false;					
		}
		
		return (differBy == 1) ? true : false;
	}
	
	// stores the word and its corresponding one character apart words
	protected HashMap<String, ArrayList<String>> mSimilarWords = new HashMap<String, ArrayList<String>>();
	
	// Groups all the words based on their length
	protected HashMap<Integer, ArrayList<String>> mWordGroupByLength = new HashMap<Integer, ArrayList<String>>();
	
	/**
	 * 
	 */
	private void groupWordsByLength()
	{
		for(String word : mWordList.words())
		{
			addToGroup(word);
		}
			
	}
	
	// adds item to the mWordGroupByLength
	private void addToGroup(String word)
	{
		if(!mWordGroupByLength.containsKey(word.length()))
			mWordGroupByLength.put(Integer.valueOf(word.length()), new ArrayList<String>());
		
		mWordGroupByLength.get(Integer.valueOf(word.length())).add(word);
	}
	
	// adds item to the mSimilarWords
	private void addToSimilarWords(String word, String similar)
	{
		if(!mSimilarWords.containsKey(word))
			mSimilarWords.put(word, new ArrayList<String>());
		
		mSimilarWords.get(word).add(similar);
				
	}
	
	private WordList mWordList;
}