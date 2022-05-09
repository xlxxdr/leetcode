package code.competitions._290;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _6041_intersection {

	public static void main(String[] args) {
		_6041_intersection app = new _6041_intersection();
		//[[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
		List<Integer> list = app.intersection(new int[][] {
			{3, 1, 2, 4, 5},
			{1, 2, 3, 4},
			{3, 4, 5, 6}
		});
		System.out.println("list = " + list);
		list = app.intersection(new int[][] {
			{1, 2, 3},
			{4, 5, 6},
		});
		System.out.println("list = " + list);

		//[[7,34,45,10,12,27,13],[27,21,45,10,12,13]]
		list = app.intersection(new int[][] {
			{7,34,45,10,12,27,13},
			{27,21,45,10,12,13},
		});
		//[10,12,13,27,45]
		System.out.println("list = " + list);
	}

	public List<Integer> intersection(int[][] nums) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i : nums[0]) {
			numMap.put(i, i);
		}
		for (int i = 1; i < nums.length; i++) {
			Map<Integer, Integer> intersectionMap = new HashMap<>();
			for (int k = 0; k < nums[i].length; k++) {
				if (numMap.containsKey(nums[i][k])) {
					intersectionMap.put(nums[i][k],nums[i][k]);
				}
			}
			numMap = intersectionMap;
		}
		Set<Integer> keys = numMap.keySet();
		ArrayList<Integer> result = new ArrayList<>(keys);
		Collections.sort(result);
		return result;
	}

}
