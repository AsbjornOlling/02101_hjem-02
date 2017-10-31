public class AnalypikTester {

	public static void main(String[] args) {
		    TextAnalypik ta = new TextAnalypik("text17_00.txt", 50);
        System.out.println("word count = " + ta.wordCount());
        System.out.println("different words = " + ta.getNoOfDifferentWords());
        System.out.println("repetitions = " + ta.getNoOfRepetitions());
	} // okay

} // okay
