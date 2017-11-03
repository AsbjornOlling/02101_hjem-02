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
import java.util.ArrayList;
public class TextAnalysis {
public int wordCount;
public int getNoOfDifferentWords;
public int getNoOfRepetitions;
	
	public static void main(String[] args) {
		new TextAnalysis("text17_01.txt",50);
	}
	
	BufferedReader reader;
	String line;
	String sourceFileName = "text17_01.txt";
	public TextAnalysis (String sourceFileName, int maxNoOfWords) {
		BufferedReader reader = null;
		try {
		    File file = new File("sourceFileName");
		    reader = new BufferedReader(new FileReader(file));

		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		// counter starter paa 0
		wordCount=0;

		//
		String singleWord = null;
		
		//Array for unikke ord
		ArrayList uniqueWords = new ArrayList();
		
		// saa laenge der er linjer koeres dette loop
		while (sc.hasNextLine()) {
			//
			String aLine = sc.nextLine();
			
			// Splitter linjerne op i arrays bestaaende af ord
			String[] textArray = aLine.split("[^a-zA-Z-']+"); // saadan her? hvad med tyske tegn?
			
			String[] blankLine= {};
			int arrayLength;
			if (!(textArray==blankLine)) {
				// Antal ord paa linjen
				arrayLength=textArray.length;
				wordCount+=arrayLength;
			}else {
			break;
			}

			System.out.println(wordCount);
			// Taeller summen af alle ord sammen
			
			// Lav et for loop... saet det til i, naar du ikke har brug for stoettehjul
			int i;
			
			//
			for (i=0;i<arrayLength;i++) {
				singleWord = textArray[i];
				if (!uniqueWords.contains(singleWord)) {
					uniqueWords.add(singleWord);
					i++;
				}else {
				i++;
				}			
			}
		}
		
		//
		getNoOfDifferentWords = uniqueWords.size();
		
		/*System.out.println(getNoOfDifferentWords);
		System.out.println(uniqueWords);
		System.out.println(getNoOfRepetitions);*/
	}
	
	public int wordCount () {
		return wordCount;
	}
	
	public int getNoOfDifferentWords () {
		return getNoOfDifferentWords;
	}
	
	public int getNoOfRepetitions () {
		return getNoOfRepetitions;
	}
	
}