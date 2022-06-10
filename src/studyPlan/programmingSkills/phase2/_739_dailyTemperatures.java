package studyPlan.programmingSkills.phase2;

import tools.Asserts;

//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
//
// 示例 1:
//
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
//
//
// 示例 3:
//
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 10⁵
// 30 <= temperatures[i] <= 100
//
// Related Topics 栈 数组 单调栈 👍 1180 👎 0

public class _739_dailyTemperatures extends Asserts {

	public static void main(String[] args) {
		_739_dailyTemperatures app = new _739_dailyTemperatures();
		equals(getIntArray("[1,1,4,2,1,1,0,0]"),app.dailyTemperatures(getIntArray("[73,74,75,71,69,72,76,73]")));
		equals(getIntArray("[1,1,0]"),app.dailyTemperatures(getIntArray("[30,60,90]")));
		equals(getIntArray("[1,1,1,0]"),app.dailyTemperatures(getIntArray("[30,40,50,60]")));
	}

	public int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			for (int j = i + 1; j < temperatures.length; j++) {
				if (temperatures[j] > temperatures[i]) {
					result[i] = j - i;
					break;
				}
			}
		}
		return result;
	}

}
