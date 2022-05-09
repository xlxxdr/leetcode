package code.competitions._290;

public class _6042_countLatticePoints {

	public static void main(String[] args) {
		_6042_countLatticePoints app = new _6042_countLatticePoints();
		int result = app.countLatticePoints(new int[][] {
			{2, 2, 1}
		});
		System.out.println("result = " + result);

		result = app.countLatticePoints(new int[][] {
			{2, 2, 2},
			{3, 4, 1}
		});
		System.out.println("result = " + result);
	}

	public int countLatticePoints(int[][] circles) {
		int sum = 0;
		for (int[] circle : circles) {
			int r = circle[2];
			int count = (int)(Math.pow(r + 1, 2)) * 2 - ((r << 1) + 1);
			sum += count;
		}
		sum -= getMergePointCount(circles);
		return sum;
	}

	private int getMergePointCount(int[][]  circle) {
		return 0;
	}

}
