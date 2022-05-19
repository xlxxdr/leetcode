package code.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tools.Asserts;

public class _977_SortedSquares {

	public static void main(String[] args) {
		_977_SortedSquares app = new _977_SortedSquares();
		Asserts.equals(new int[] {0, 1, 9, 16, 100}, app.sortedSquares(new int[] {-4, -1, 0, 3, 10}));
		Asserts.equals(new int[] {4, 9, 9, 49, 121}, app.sortedSquares(new int[] {-7, -3, 2, 3, 11}));
	}

	public int[] sortedSquares(int[] nums) {
		List<Integer> nList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			nList.add(nums[i] * nums[i]);
		}
		Collections.sort(nList);
		for (int i = 0; i < nList.size(); i++) {
			nums[i] = nList.get(i);
		}
		return nums;
	}

}
