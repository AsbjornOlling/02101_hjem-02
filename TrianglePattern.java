/* 
	Problem 2 
	Hjemmeopgave 2 - Indledende Programmering
	Asbjørn Olling
 */ 

// 1d pattern
// growing process is top-down

// h rows
// n cells per row
// int[] initial: indexes of filled columns in row 0

// 1. seeds are planted in row 0
// 2. growing process starts top down

public class TrianglePattern {
	private int n, h;
	private int[] initial;

	// constructor
	public TrianglePattern(int n, int h, int[] initial) {
		h = h;
		n = n;
		initial = initial;
	} // constructor


	// return 0 if empty
	// return 1 if filled
	public int getValueAt(int r, int c) {
		return 0;
	} // getValueAt


	// getter methods
	public int getN() {
		return n;
	}
	public int getH() {
		return h;
	}
	public int[] getInitial() {
		return initial;
	} // getters

}
