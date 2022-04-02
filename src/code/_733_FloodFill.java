package code;

public class _733_FloodFill {

	public static void main(String[] args) {
		int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		floodFill(image, 1, 1, 2);
		for (int x = 0; x < image.length; x++) {
			for (int y = 0; y < image[x].length; y++) {
				System.out.print(image[x][y] + ",");
			}
			System.out.println();
		}

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		fillColor(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	private static void fillColor(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor || image[sr][sc] != oldColor) {
			return;
		}
		image[sr][sc] = newColor;
		// 上 sr - 1, sc
		fillColor(image, sr - 1, sc, newColor, oldColor);
		// 下 sr + 1, sc
		fillColor(image, sr + 1, sc, newColor, oldColor);
		// 左 sr, sc - 1
		fillColor(image, sr, sc - 1, newColor, oldColor);
		// 右 sr, sc + 1
		fillColor(image, sr, sc + 1, newColor, oldColor);
	}
}
