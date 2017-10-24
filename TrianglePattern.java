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
	// declare class fields
	private int h,n;
	private int[] initial;
	// TODO: make this private, once done with testing
	public int[][] grid;

	/*
	public static void main(String args[]) {
		System.out.println("Hello world!");
	}
	// */

	// constructor
	// main code of the simulation
	public TrianglePattern(int n, int h, int[] initial) {
		// put arguments into instance fields
		this.h = h;
		this.n = n;
		this.initial = initial;
	
		// initialize grid array	
		grid = new int[h][n];
		
		// put initial[] into the first row of grid
		int index;
		for (int i = 0; i < initial.length; i++) {
			// initial[] is an array of the indices that are filled 
			index = initial[i];
			// put a 1 in the appropriate indices
			grid[0][index] = 1;
		}

		// loop through rows, starting with second row
		int nwBlock,nBlock,neBlock; // "northwest", "north", and "northeast" blocks
		for (int i = 1; i < h; i++) {

			// loop through cells in row, from second to second-last cell 
			// (because the first and last dont have NW and NE blocks)
			for (int j = 1; j < n-1; j++) {
				// get states of line above
				nwBlock = grid[i-1][j-1];
				nBlock = grid[i-1][j];
				neBlock = grid[i-1][j+1];

				// narrow down cases - similar to binary search??
				// first four cases:
				if (nwBlock == 0) {

					// first two cases
					if (nBlock == 0) {

						// first case
						if (neBlock == 0) {
							grid[i][j] = 0;
						}

						// second case
						if (neBlock == 1) {
							grid[i][j] = 1;
						}
					} 

					// third and fourth cases give the same output
					else if (nBlock == 1) {
						grid[i][j] = 1;
					}
				} // end of first four

				// last four cases
				else if (nwBlock == 1) {

					// fifth and sixth cases
					if (nBlock == 0) {

						// fifth case
						if (neBlock == 0) {
							grid[i][j] = 1;
						}
						
						// sixth case
						else if (neBlock == 1) {
							grid[i][j] = 0;
						}

					}

					// last two cases give the same output
					else if (nBlock == 1) {
						grid[i][j] = 0;
					}
				} // end of all 8 cases

			} // cells loop

		} // rows loop

	} // constructor


	// getter methods
	// TODO none of these work...
	public int getValueAt(int r, int c) {
		// it never reaches this line
		return grid[r][c];
	} //*/ 
	public int getN() {
		return this.n;
	}
	public int getH() {
		return this.h;
	}
	public int[] getInitial() {
		return this.initial;
	} // getters

} // class
