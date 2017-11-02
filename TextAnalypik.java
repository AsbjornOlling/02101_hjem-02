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
	private Scanner text;
	public ArrayList<String> uniqueWords = new ArrayList<String>();
	public ArrayList<String> allWords = new ArrayList<String>();
	public int maxNoOfWords;
	public int wordCount;
	public int immediateRepetitions;

	public TextAnalypik(String sourceFileName, int maxNoOfWords) {
		this.maxNoOfWords = maxNoOfWords;

		// open the file
		try {
			text = new Scanner(new File(sourceFileName));
		} catch (FileNotFoundException ex) {
			System.out.println("ERROR: The file wasn't found.");
		} //*/

		// declare the vars used in the loop
		String previousWord = "";
		String[] arrayOfWords;

		// go through the individual lines of the file
		while (text.hasNextLine()) {
			
			// put a single line into an array of words
			arrayOfWords = text.nextLine().split("[^a-zA-Z]+");

			// go through the words in a single line
			for (String word : arrayOfWords) {

				// handle cases where arrayOfWords is empty
				if (word.length() == 0) {
					System.out.print("NOT WORD: "+word+"\n");
					break;
				} //*/
				System.out.print("WORD: "+word);
				allWords.add(word);

				// make lowercase, and check for uniqueness
				word = word.toLowerCase();
				if (!uniqueWords.contains(word)) {
					uniqueWords.add(word);
					System.out.print(" UNIQUE");
				} //*/

				// count an immediate repetition, if last word equals this word
				if (previousWord.equals(word)) {
					immediateRepetitions++;
					System.out.print(" REPEATED");
				} //*/

				wordCount++;
				System.out.print(" COUNT: "+wordCount+"\n");
				System.out.print(" COUNT2: "+allWords.size()+"\n");

				// set new previous word
				previousWord = word;

			} // words loop
			if(wordCount >= maxNoOfWords) {
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
