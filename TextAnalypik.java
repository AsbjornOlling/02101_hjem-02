/*
 Problem 1 
 Hjemmeopgave 2 - Indledende Programmering
 Asbjørn Olling
*/

import java.util.Scanner; // to read the file
import java.util.Arrays;
import java.util.ArrayList; // for uniqueworsd list
import java.io.*; // for File and FileNotFoundException

// number of words
// number of unique words
// number of immediate repetitions

public class TextAnalypik {
	// fields
	private Scanner text;
	public ArrayList<String> uniqueWords = new ArrayList<String>();
	public int maxNoOfWords;
	public int wordCount;
	public int immediateRepetitions;

	public TextAnalypik(String sourceFileName, int maxNoOfWords) {
		this.maxNoOfWords = maxNoOfWords;

		try { // open the file
			text = new Scanner(new File(sourceFileName));
		} catch (FileNotFoundException ex) {
			System.out.println("The file wasn't found.");
		} // file opened - probably

		// go through the individual lines of the file
		String aLine;
		String[] wordsInLine;
		wordCount = 0;
		String previousWord = "";
		while (text.hasNextLine()) {
			// pull out a line
			aLine = text.nextLine();

			// split the line into words
			wordsInLine = aLine.split("[^a-zA-Z]+");

			// System.out.println(wordsInLine[0]);
			// the first word is always unique - add to the unique words list
			uniqueWords.add(wordsInLine[0]);
			
			// go through the words
			// until line runs out, or max words reached
			String word;
			for (int i = 0; i < wordsInLine.length && wordCount < maxNoOfWords; i++) {
				// count each word
				wordCount++;

				// give the word a better name
				word = wordsInLine[i];

				// if word not in list of unique words
				// add to list of unique words
				if (uniqueWords.contains(word)) {
					uniqueWords.add(word);
				} //*/

				// count an immediate repetition if last word equals this word
				if (previousWord.equals(word)) {
					immediateRepetitions++;
				}

				// set new previous word
				previousWord = word;
			} // words list

			// stop reading new lines if max words reached
			if (wordCount >= maxNoOfWords) {
				break;
			}
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
