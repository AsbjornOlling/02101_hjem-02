/*
 Problem 1 
 Hjemmeopgave 2 - Indledende Programmering
 Asbjørn Olling
*/

import java.util.Scanner;
import java.io.*; // for File and FileNotFoundException
import java.util.Arrays;

// number of words
// number of unique words
// number of immediate repetitions

public class TextAnalypik {
	// fields
	public Scanner sc;
	public String[] uniqueWords;
	public int maxNoOfWords;
	public int wordCount;
	public int immediateRepetitions;

	public TextAnalypik(String sourceFileName, int maxNoOfWords) {
		this.maxNoOfWords = maxNoOfWords;

		try { // open the file
			sc = new Scanner(new File(sourceFileName));
		} catch (FileNotFoundException ex) {
			System.out.println("Sut løg - din kode virker ik en skid");
		} // file opened - probably

		// pull all words into a giant array
		String aLine;
		String[] wordsInLine;
		while (sc.hasNextLine()) {
			// pull out a line
			aLine = sc.nextLine();

			// split the line into words
			wordsInLine = aLine.split("[^a-zA-Z]+");
			
			// go through the words
			wordCount = 0;
			String previousWord = "";
			String word;
			for (int i = 0; i < wordsInLine.length && wordCount < maxNoOfWords; i++) {
				word = wordsInLine[i];

				// TODO write this bit
				// if word not in list of unique words
				// add to list of unique words

				// The bit that checks for immediate repetitions
				if (previousWord.equals(word)) {
					immediateRepetitions++;
				}
				// set new previous word
				previousWord = word;

				// count each word
				wordCount++;
			} // for

			// stop reading new lines when max amount of words reached
			if (wordCount == maxNoOfWords) {
				break;
			} else if (wordCount > maxNoOfWords) {
				System.out.println("Something went wrong, wordcount larger than max.");
			}
		} // while

		public int wordCount() {
			return wordCount;
		}


	} // constructor

} // class
