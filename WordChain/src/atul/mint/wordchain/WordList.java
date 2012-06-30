package atul.mint.wordchain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


/**
 * @class - WordList
 * 
 * @brief - This class creates a list of words based on the dictionary
 * 
 * @author atul
 *
 */
public class WordList 
{
	public WordList(String pathToDictionary)
	{
		createWordList(pathToDictionary);
	}
	
	/**
	 * Getter for the list of words
	 * 
	 * @return - list of word
	 */
	public List<String> words()
	{
		return mWords;
	}
	
	/**
	 * Reads the file from files/ directory and creates a list
	 * 
	 * @param pathToDictionary - location of the dictionary
	 */
	private void createWordList(String pathToDictionary)
	{
		BufferedReader reader = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(pathToDictionary));
			String line = null;
			
			while((line = reader.readLine()) != null)
			{
				mWords.add(line);
			}
		}
		catch(Exception e) 
		{
			return;
		}
		
		finally
		{
			closeReader(reader);
		}
	}
	
	private void closeReader(Reader reader)
	{
		try 
		{
			reader.close();
		} 
		catch (Exception e) 
		{
			if(reader != null)
				reader = null;
		}
		
	}
	
	// Represents the dictionary of words
	private List<String> mWords = new ArrayList<String>();

}
