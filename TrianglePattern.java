/*
 Problem 2 
 Hjemmeopgave 2 - Indledende Programmering
 Asbjørn Olling
*/ 

// h rows
// n cells per row
// int[] initial: indices of filled columns in row 0

public class TrianglePattern {
	// declare class fields
	private int h,n;
	private int[] initial;
	private int[][] grid;

	// main code for generating the pattern
	public TrianglePattern(int n, int h, int[] initial) {
		// put parameters into instance fields
		this.h = h;
		this.n = n;
		this.initial = initial;
	
		// declare grid array	
		grid = new int[h][n];
		
		// put initial[] into the first row of grid
		int index;
		for (int i = 0; i < initial.length; i++) {
			// initial[] is an array of the indices that are filled 
			index = initial[i];
			// put an int 1 in the mentioned indices
			grid[0][index] = 1;
		}

		// declare "northwest", "north", and "northeast" blocks
		int nwBlock,nBlock,neBlock; 
		// loop through rows, starting with second row
		for (int i = 1; i < h; i++) {

			// loop through cells in row, from second to second-last cell 
			// (because the first and last dont have NW and NE blocks)
			for (int j = 1; j < n-1; j++) {
				// get states of line above
				nwBlock = grid[i-1][j-1];
				nBlock = grid[i-1][j];
				neBlock = grid[i-1][j+1];

				// since the cases are already sorted in the assignment
				// we can narrow down the cases, like a hardcoded binary search
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
					// no need to check for which
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
	public int getValueAt(int r, int c) {
		return grid[r][c];
	}
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
