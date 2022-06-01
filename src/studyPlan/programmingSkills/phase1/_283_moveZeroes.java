package studyPlan.programmingSkills.phase1;

import tools.Asserts;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
// 示例 1:
//
//
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
//
// 示例 2:
//
//
//输入: nums = [0]
//输出: [0]
//
//
//
// 提示:
//
//
//
// 1 <= nums.length <= 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
//
//
//
//
// 进阶：你能尽量减少完成的操作次数吗？
// Related Topics 数组 双指针 👍 1603 👎 0

public class _283_moveZeroes extends Asserts {

	public static void main(String[] args) {
		_283_moveZeroes app = new _283_moveZeroes();
		int[] array = getIntArray("[0,1,0,3,12]");
		app.moveZeroes(array);
		equals(getIntArray("[1,3,12,0,0]"), array);
		array = new int[] {0};
		app.moveZeroes(array);
		equals(getIntArray("[0]"), array);

		array = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 1};
		app.moveZeroes(array);
		equals(getIntArray(1, 0, 0, 0, 0, 0, 0, 0, 0), array);
		array = new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0};
		app.moveZeroes(array);
		equals(getIntArray(1, 0, 0, 0, 0, 0, 0, 0, 0), array);

		array = new int[] {0, 0, 0, 0, 1, 0, 0, 0, 0};
		app.moveZeroes(array);
		equals(getIntArray(1, 0, 0, 0, 0, 0, 0, 0, 0), array);
	}

	public void moveZeroes1(int[] nums) {
		if (nums.length == 1) {
			return;
		}
		int left = 0;
		int right = 1;
		while (right != nums.length) {
			if (nums[left] == 0 && nums[right] != 0) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right++;
			} else if (nums[left] == 0 && nums[right] == 0) {
				right++;
			} else if (nums[left] != 0 && nums[right] != 0) {
				left = right;
				right++;
			} else if (nums[left] != 0 && nums[right] == 0) {
				left++;
				right++;
			}
		}
	}

	public void moveZeroes(int[] nums) {
		int p1 = 0;
		int p2 = 0;
		while (p2 < nums.length) {
			if (nums[p1] == 0) {
				//如果第一个元素为0，则p2应该找到下一个非零元素的位置,如果没有，返回数组长度
				p2 = nextNonZeroPos(p2, nums);
				if (p2 != -1) {
					int tmp = nums[p1];
					nums[p1] = nums[p2];
					nums[p2] = tmp;
					p1++;
				} else {
					break;
				}
			} else {
				p1 = nextZeroPos(p1, nums);
				p2 = p1;
				if (p1 == -1) {
					break;
				}
			}
		}
	}

	private int nextZeroPos(int p1, int[] nums) {
		for (int i = p1; i < nums.length; i++) {
			if (nums[i] == 0) {
				return i;
			}
		}
		return -1;
	}

	private int nextNonZeroPos(int p2, int[] nums) {
		for (int i = p2; i < nums.length; i++) {
			if (nums[i] != 0) {
				return i;
			}
		}
		return -1;
	}

}
