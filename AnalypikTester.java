public class AnalypikTester {

	public static void main(String[] args) throws Exception {
	/*
		System.out.println("00:"); 
    TextAnalypik ta0 = new TextAnalypik("text17_00.txt", 50);
        System.out.println("word count = " + ta0.wordCount());
        System.out.println("different words = " + ta0.getNoOfDifferentWords());
        System.out.println("repetitions = " + ta0.getNoOfRepetitions());

		System.out.println("01:");
    TextAnalypik ta1 = new TextAnalypik("text17_01.txt", 50);
        System.out.println("word count = " + ta1.wordCount());
        System.out.println("different words = " + ta1.getNoOfDifferentWords());
        System.out.println("repetitions = " + ta1.getNoOfRepetitions());

		System.out.println("02:");
    TextAnalypik ta2 = new TextAnalypik("text17_02.txt", 50);
        System.out.println("word count = " + ta2.wordCount());
        System.out.println("different words = " + ta2.getNoOfDifferentWords());
        System.out.println("repetitions = " + ta2.getNoOfRepetitions());
		//*/

		System.out.println("HAMLET:");
    TextAnalypik hamlet	= new TextAnalypik("hamlet.txt", 50000);
        System.out.println("word count = " + hamlet.wordCount());
        System.out.println("different words = " + hamlet.getNoOfDifferentWords());
        System.out.println("repetitions = " + hamlet.getNoOfRepetitions());
	} // okay

} // okay
