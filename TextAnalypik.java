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

public class TextAnalypik {
	// fields
	private BufferedReader text;
	private int wordCount = 0;
	private int immediateRepetitions = 0;
	private ArrayList<String> uniqueWords = new ArrayList<String>();

	// constructor - does all of the main work counting words
	public TextAnalypik(String sourceFileName, int maxNoOfWords) throws Exception {

		// open the file
		try {
			text = new BufferedReader(new FileReader(sourceFileName));
		} catch (FileNotFoundException ex) {
			System.out.println("ERROR: The file wasn't found, or could not be read.");
		} //*/

		// declare some vars needed in the loops
		String previousWord = "";
		String line = "";

		// pull a single line, stop when there are no more lines
		linesLoop:
		while ( text.ready() ) {

			do { // if line is empty, get a new one
				line = text.readLine();
			} while (line.length() == 0); 

			// pull out letter-only words into an array
			String[] arrayOfWords = line.split("[^a-zA-Z]+");
			System.out.println(Arrays.toString(arrayOfWords));

			// go through the words in a single line
			wordsLoop:
			for ( int i = 0; i < arrayOfWords.length; i++) {

				String word = arrayOfWords[i];
				System.out.println(word);

				// This is my fucking problem	
				// TODO fix my fucking problem
				if (word.length() == 0) {
					break wordsLoop;
				} //*/

				// count the word
				wordCount = wordCount + 1;

				// check for case-insensitive uniqueness
				word = word.toLowerCase();
				if (!uniqueWords.contains(word)) {
					uniqueWords.add(word);
				} 

				// count an immediate repetition, if last word equals this word
				if (previousWord.equals(word)) {
					immediateRepetitions = immediateRepetitions + 1;
				}

				// set this word as the new previous word
				previousWord = word;

				// break out of both nested loops, if wordcount reached (or exceeded)
				if(wordCount >= maxNoOfWords) { 
					break linesLoop;
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
