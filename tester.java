public class tester {
	public static void main(String args[]) {
		int[] init = {17};
		int n = 44;
		int h = 20;

		TrianglePattern tp = new TrianglePattern(n, h, init);

		System.out.println(tp.grid.length);
		for (int i = 0; i < tp.grid.length; i++) {
			for (int j = 0; j < tp.grid[i].length; j++) {
				System.out.print(tp.grid[i][j]);
			}
			System.out.println();
		}

	}
}
