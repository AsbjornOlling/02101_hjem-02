/*
 Problem 1 
 Hjemmeopgave 2 - Indledende Programmering
 Asbjørn Olling
*/

import java.util.Scanner; // to read the file
import java.util.Arrays;
import java.util.ArrayList; // for uniqueworsd list
import java.io.*; // for File and FileNotFoundException and BufferedReader
import java.io.BufferedReader;
import java.io.FileReader;

// number of words
// number of unique words
// number of immediate repetitions

// HAMLET NOTES:
// underestimates wordcount
// underestimates unique wordcount
// underestimates repeated words
// linecount is on point
//
// if not checking wordlength == 0
// 	wordcount way over
// 	unique wordcount on point
// 	repetitions way over (+850)

public class TextAnalypik {
	// fields
	public BufferedReader text;
	public ArrayList<String> uniqueWords = new ArrayList<String>();
	public ArrayList<String> allWords = new ArrayList<String>();
	public int maxNoOfWords;
	public int wordCount;
	public int immediateRepetitions;

	public TextAnalypik(String sourceFileName, int maxNoOfWords) throws Exception {

		// open the file
		try {
			BufferedReader text = new BufferedReader(new FileReader(sourceFileName));
		} catch (FileNotFoundException ex) {
			System.out.println("ERROR: The file wasn't found, or could not be read.");
		} //*/

		// declare some vars needed in the loops
		String previousWord = "";
		String line;

		// pull a single line, stop when there are no more lines
		readingLoop:
		while ( ( line = text.readLine() ) != null ) {

			// pull out letter-only words into an array
			String[] arrayOfWords = line.split("[^a-zA-Z]+");

			// go through the words in a single line
			for (String word : arrayOfWords) {

				// handle cases with empty lines
				if (word.length() == 0) {
					break;
				}

				// count the word
				wordCount++;

				// check for case-insensitive uniqueness
				word = word.toLowerCase();
				if (!uniqueWords.contains(word)) {
					uniqueWords.add(word);
				} 

				// count an immediate repetition, if last word equals this word
				if (previousWord.equals(word)) {
					immediateRepetitions++;
				}

				// set this word as the new previous word
				previousWord = word;

				// break out of both nested loops, if wordcount reached (or exceeded)
				if(wordCount >= maxNoOfWords) { 
					break readingLoop;
				}
			} // words loop
		} // lines loop
	} // constructor

	// here come the getter methods
	public int wordCount() {
		return wordCount;
	} 
	public int getNoOfDifferentWords() {
		return uniqueWords.size();
	} //*/
	public int getNoOfRepetitions() {
		return immediateRepetitions;
	}
			
} // class
