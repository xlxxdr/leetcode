package competitions._290;

import java.util.Arrays;

public class _6043_countRectangles {

	public static void main(String[] args) {
		_6043_countRectangles app = new _6043_countRectangles();
		//[[1,1],[2,2],[3,3]], points = [[1,3],[1,1]]
		int[] counts = app.countRectangles(new int[][] {
			{1, 1},
			{2, 2},
			{3, 3}
		}, new int[][] {
			{1, 3},
			{1, 1}
		});
		System.out.println("counts = " + Arrays.toString(counts));
		counts = app.countRectangles(new int[][] {
			{1, 2},
			{2, 3},
			{2, 5}
		}, new int[][] {
			{2, 1},
			{1, 4}
		});
		System.out.println("counts = " + Arrays.toString(counts));

	}

	public int[] countRectangles(int[][] rectangles, int[][] points) {
		int[] result = new int[points.length];
		int flag = 0;
		for (int[] point : points) {
			int pX = point[0];
			int pY = point[1];
			int count = 0;
			for (int i = 0; i < rectangles.length; i++) {
				int rX = rectangles[i][0];
				int rY = rectangles[i][1];
				if (pX > rX && pY > rY) {
					break;
				} else {
					count++;
				}
			}
			result[flag] = count;
			flag++;
		}
		return result;
	}
}
