package studyPlan.programmingSkills.phase2;

import tools.Asserts;

//如果数组是单调递增或单调递减的，那么它是 单调 的。
//
// 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> =
//nums[j]，那么数组 nums 是单调递减的。
//
// 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：nums = [6,5,4,4]
//输出：true
//
//
// 示例 3：
//
//
//输入：nums = [1,3,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁵ <= nums[i] <= 10⁵
//
// Related Topics 数组 👍 164 👎 0

public class _896_isMonotonic extends Asserts {

	public static void main(String[] args) {
		_896_isMonotonic app = new _896_isMonotonic();
		isTrue(app.isMonotonic(getIntArray("[1,2,2,3]")));
		isTrue(app.isMonotonic(getIntArray("[6,5,4,4]")));
		isFalse(app.isMonotonic(getIntArray("[1,3,2]")));
		isTrue(app.isMonotonic(getIntArray("[1,1,0]")));
		isTrue(app.isMonotonic(getIntArray("[2,2,2,2]")));
		isTrue(app.isMonotonic(getIntArray("[2,2,2,1]")));
		isTrue(app.isMonotonic(getIntArray("[2,2,2,3]")));
		isFalse(app.isMonotonic(getIntArray("[2,2,2,3,1]")));
	}

	public boolean isMonotonic(int[] nums) {
		if (nums.length == 1) {
			return true;
		} else {
			boolean incr = true;
			int pos = 0;
			for (int i = 0; i < nums.length - 1 ; i++) {
				if (nums[i] < nums[i + 1]) {
					pos = i + 1;
					incr = true;
					break;
				} else if (nums[i] > nums[i + 1]) {
					incr = false;
					pos = i + 1;
					break;
				} else {
					continue;
				}
			}
			for (int i = pos; i < nums.length - 1; i++) {
				if (incr) {
					if (nums[i] > nums[i + 1]) {
						return false;
					}
				} else {
					if (nums[i] <  nums[i + 1]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
