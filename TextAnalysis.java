//TextReader
//public int wordCount ()
//public int getNoOfDifferentWords ()
//public int getNoOfRepetitions ()
	
//A word is a non-empty string consisting only of letters (a,. . . ,z,A,. . . ,Z),
//surrounded by blanks, punctuation, hyphenation, line start, or line end.
//In the analysis, punctuation is ignored. The analysis is non-case-sensitive.
	

/*	String text = "hej med dig";
	String[] tokens = text.split("[^a-zA-Z]+");
	System.out.println(Arrays.toString(tokens));
	int Arraylength=tokens.length();
	System.out.prinln(Arraylength);
*/

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
public class TextAnalysis {
	public static void main(String[] args) {
	}
	
	public Scanner sc;
	public TextAnalysis (String sourceFileName, int maxNoOfWords) {
		sourceFileName = "text17_01.txt";
		try {
			Scanner sc = new Scanner( new File(sourceFileName));	
		}catch (FileNotFoundException ex){
			System.out.println("fejl");
		}
		
		// counter starter paa 0
		int wordCount=0;
		
		// saa laenge der er linjer koeres dette loop
		while (sc.hasNextLine()) {
			String aLine = sc.nextLine();
			
			// Splitter linjerne op i arrays bestaaende af ord
			String[] text = aLine.split("[^a-zA-Z-']+"); // saadan her? hvad med tyske tegn?
			
			// Antal ord paa linjen
			int Arraylength=text.length;
			
			// Taeller summen af alle ord sammen
			wordCount+=Arraylength;
			
			// Number of different words
			// Mulige metoder:
			// Skab et nyt array
			// Alfabetisk sortering
		}	// 
	}
	
	public int wordCount () {
		return wordCount();
	}
	
	public int getNoOfDifferentWords () {
		return getNoOfDifferentWords();
	}
	
	public int getNoOfRepetitions () {
		return getNoOfRepetitions();
	}
	
}