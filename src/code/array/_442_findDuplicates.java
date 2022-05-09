package code.array;

import code.tools.Asserts;

import java.util.*;

public class _442_findDuplicates {

    public static void main(String[] args) {
        _442_findDuplicates app = new _442_findDuplicates();
        Asserts.equals(Arrays.asList(2,3),app.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        Asserts.equals(Arrays.asList(1),app.findDuplicates(new int[]{1,1,2}));
        Asserts.equals(new ArrayList<>(),app.findDuplicates(new int[]{1,2}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap();
        List<Integer> duplicateList = new ArrayList<>();
        for(int n: nums){
            if (countMap.containsKey(n)){
                Integer count = countMap.get(n);
                if (count == 1){
                    duplicateList.add(n);
                } else {
                    duplicateList.remove(n);
                }
                countMap.put(n, count +1);

            } else {
                countMap.put(n,1);
            }
        }
        return duplicateList;
    }
}
