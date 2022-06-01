package studyPlan.programmingSkills.phase1;

import tools.Asserts;

//给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来
//判断，这些点是否在该坐标系中属于同一条直线上。
//
//
//
// 示例 1：
//
//
//
//
//输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
//12
//
// 示例 2：
//
//
//
//
//输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
//
//
//
//
// 提示：
//
//
// 2 <= coordinates.length <= 1000
// coordinates[i].length == 2
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
// coordinates 中不含重复的点
//
// Related Topics 几何 数组 数学 👍 113 👎 0
public class _1232_checkStraightLine extends Asserts {

	public static void main(String[] args) {
		_1232_checkStraightLine app = new _1232_checkStraightLine();
		isFalse(app.checkStraightLine(getInt2DArrayFromString("[[1,1],[2,2],[2,1],[3,2]]")));
		isTrue(app.checkStraightLine(getInt2DArrayFromString("[[-3,-2],[-1,-2],[2,-2],[-2,-2],[0,-2]]")));
		isTrue(app.checkStraightLine(getInt2DArrayFromString("[[2,4],[2,5],[2,8]]")));
		isTrue(app.checkStraightLine(getInt2DArrayFromString("[[0,0],[0,1],[0,-1]]")));
		isFalse(app.checkStraightLine(getInt2DArrayFromString("[[0,0],[0,5],[5,5],[5,0]]")));
		isTrue(app.checkStraightLine(getInt2DArrayFromString("[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]")));
		isFalse(app.checkStraightLine(getInt2DArrayFromString("[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]")));
	}

	public boolean checkStraightLine(int[][] coordinates) {
		int x = coordinates[1][0] - coordinates[0][0], y = coordinates[1][1] - coordinates[0][1], dx, dy;
		for (int i = 2; i < coordinates.length; i++) {
			dx = coordinates[i][0] - coordinates[0][0];
			dy = coordinates[i][1] - coordinates[0][1];
			if (x * dy != y * dx)
				return false;
		}
		return true;
	}


}
