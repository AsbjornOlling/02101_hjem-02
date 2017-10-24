import java.util.Arrays;

public class tester {
	public static void main(String args[]) {
		int[] init = {10};
		int n = 21;
		int h = 8;

		TrianglePattern tp = new TrianglePattern(n, h, init);

		// print pattern as ascii art
		for (int i = 0; i < tp.grid.length; i++) {
			for (int j = 0; j < tp.grid[i].length; j++) {
				System.out.print(tp.grid[i][j]);
			}
			System.out.println();
		}

		// test getter functions
		System.out.println(tp.getH());
		System.out.println(tp.getN());
		System.out.println(Arrays.toString(tp.getInitial()));

	}
}
