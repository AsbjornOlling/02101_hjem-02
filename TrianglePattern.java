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
// 		loops h times
// 3. generate graphic using TPViewer

public class TrianglePattern {
	// declare fields
	private int h, n;
	private int[] initial;
	private int[][] grid = new int[h][n];

	/*
	public static void main(String args[]) {
		System.out.println("Hello world!");
		// zuck shit
	}
	// */

	// constructor
	// main code of the simulation
	public TrianglePattern(int n, int h, int[] initial) {
		// put arguments into instance fields
		h = h;
		n = n;
		initial = initial;
		int nwBlock,nBlock,neBlock;
		
		// put initial[] into the first row of grid
		int index;
		for (int i = 0; i < initial.length; i++) {
			// initial[] is an array of the indices that are filled 
			index = initial[i];
			// put a 1 in the appropriate indices
			grid[0][index] = 1;
		}

		// loop through rows, starting with second row
		for (int i = 1; i < h; i++) {

			// loop through cells in row, starting with first cell
			for (int j = 0; j < n; j++) {
				// get states of line above
				// TODO take care of out-of-range idices 
				nwBlock = grid[i-1][j-1];
				nBlock = grid[i-1][j];
				neBlock = grid[i-1][j+1];

				// narrow down cases
				if (nwBlock != 1) {
					// suck shit
				} else if (nwBlock == 1) {
					// suck shit
				}

			} // cells loop

		} // rows loop

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
