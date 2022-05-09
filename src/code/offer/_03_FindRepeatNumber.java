package code.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _03_FindRepeatNumber {

    public static void main(String[] args) {
        _03_FindRepeatNumber app = new _03_FindRepeatNumber();

    }


    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.getOrDefault(num,-1) != -1){
                return num;
            } else {
                numMap.put(num,1);
            }
        }
        return -1;
    }
}
