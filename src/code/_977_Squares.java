package code;

import java.util.Arrays;

public class _977_Squares {

	public static void main(String[] args) {
		Arrays.stream(sortedSquares(new int[] {-4, -1, 0, 3, 10})).forEach(item -> System.out.print(item + ","));
		System.out.println();
		Arrays.stream(sortedSquares(new int[] {-7,-3,2,3,11})).forEach(item -> System.out.print(item + ","));
		System.out.println();
		Arrays.stream(sortedSquares(new int[] {-10000,-9999,-7,-5,0,0,10000})).forEach(item -> System.out.print(item + ","));
	}

	public static int[] sortedSquares(int[] nums) {
		if (nums.length == 1) {
			nums[0] = nums[0] * nums[0];
			return nums;
		}
		int i = 0;
		int j = nums.length - 1;
		int size = nums.length - 1;
		int retNums[] = new int[nums.length];
		while (i <= j) {
			int iNum = nums[i];
			int iSquares = iNum * iNum;
			int jNum = nums[j];
			int jSquares = jNum * jNum;
			if (jSquares > iSquares) {
				retNums[size--] = jSquares;
				j--;
			} else if (jSquares < iSquares) {
				retNums[size--] = iSquares;
				i++;
			} else if (jSquares == iSquares){
				retNums[size--] = jSquares;
				i++;
			}
		}
		return retNums;
	}
}
