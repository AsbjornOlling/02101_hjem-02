/*
 Problem 1 
 Hjemmeopgave 2 - Indledende Programmering
*/

import java.io.FileReader; // to open the file
import java.io.FileNotFoundException; // to handle missing files
import java.io.BufferedReader; // to read lines from the file
import java.util.ArrayList; // for uniquewords list

public class TextAnalysis {
	// fields
	private BufferedReader text;
	private int wordCount = 0;
	private int immediateRepetitions = 0;
	private ArrayList<String> uniqueWords = new ArrayList<String>();

	// constructor - does all of the main work counting words
	public TextAnalysis(String sourceFileName, int maxNoOfWords) throws Exception {

		// open the file
		try {
			text = new BufferedReader(new FileReader(sourceFileName));
		} catch (FileNotFoundException ex) {
			System.out.println("ERROR: The file wasn't found, or could not be read.");
		} 

		// initialize previousWord, so there is something for first check
		String previousWord = "";

		// pull a single line, stop when there are no more lines
		String line;
		linesLoop:
		while ( text.ready() ) {

			do { // if line is empty, get a new one
				line = text.readLine();
			} while (line.length() == 0); 

			// pull letter-only words into an array
			String[] arrayOfWords = line.split("[^a-zA-Z]+");

			// go through the words in the array
			for ( int i = 0; i < arrayOfWords.length; i++) {

				String word = arrayOfWords[i];

				// if word is empty, get a new one
				// stop when no more words in line
				while (word.length() == 0 && i < arrayOfWords.length) {
					i++;
					word = arrayOfWords[i];
				}

				// count the word
				wordCount++;

				// check for case-insensitive uniqueness
				word = word.toLowerCase();
				if (!uniqueWords.contains(word)) {
					uniqueWords.add(word);
				} 

				// check for immediate repetitions, still case-sensitive
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
