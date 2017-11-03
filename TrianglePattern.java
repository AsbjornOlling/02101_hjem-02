/*
 Problem 2 
 Hjemmeopgave 2 - Indledende Programmering
*/ 

// h rows
// n cells per row
// int[] initial: indices of filled columns in row 0

public class TrianglePattern {
	// declare class fields
	private int h,n;
	private int[] initial;
	private int[][] grid;

	// constructor - main code for generating the pattern
	public TrianglePattern(int n, int h, int[] initial) {
		// put parameters into instance fields
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
			// put an int 1 in the mentioned indices
			grid[0][index] = 1;
		}

		// declare "northwest", "north", and "northeast" blocks
		int nwBlock,nBlock,neBlock; 
		// loop through rows, starting with second row
		for (int y = 1; y < h; y++) {

			// loop through cells in row, from second to second-last cell 
			// (because the first and last dont have NW and NE blocks)
			for (int x = 1; x < n-1; x++) {
				// get states of line above
				nwBlock = grid[y-1][x-1];
				nBlock = grid[y-1][x];
				neBlock = grid[y-1][x+1];

				// the cases are already sorted in the assignment PDf
				// so we can narrow down the cases to only two if statments
				
				// of the four cases that have nwBlock == 0, only the first case is empty
				// so if it's nwBlock == 0, and it's NOT the first case: fill it
				if ( nwBlock == 0 && !(nBlock == 0 && neBlock == 0)  ) {
					grid[y][x] = 1;
				}
				// of the four cases that have nwBlock == 0, only the first case is filled
				// so if it's that case: fill it
				else if ( nwBlock == 1 && nBlock == 0 && neBlock == 0  ) {
					grid[y][x] = 1;
				} // end of all 8 cases
			} // cells loop
		} // rows loop
	} // constructor

	// getter methods
	public int getValueAt(int r, int c) {
		return grid[r][c];
	}
	public int getN() {
		return n;
	}
	public int getH() {
		return h;
	}
	public int[] getInitial() {
		return initial;
	} // getters

} // class
