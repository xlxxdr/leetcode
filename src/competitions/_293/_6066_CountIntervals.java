package competitions._293;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _6066_CountIntervals {

    public static void main(String[] args) {
        _6066_CountIntervals app = new _6066_CountIntervals();

    }

    class CountIntervals {

        private Map<Integer,Integer> integerMap;

        public CountIntervals() {
            integerMap = new TreeMap<>();
        }

        public void add(int left, int right) {
            if (integerMap.containsKey(left)){
                Integer existRight = integerMap.get(left);
                if (existRight <= right){
                    return;
                } else {
                    integerMap.put(existRight + 1,right);
                }
            } else {
                // 区间合并
                Set<Integer> lefts = integerMap.keySet();
                for (Integer l : lefts) {
                    Integer r = integerMap.get(l);
                    if (l <= left && r >= right ){
                       return;
                    }
                    if (l <= left && r < right){
                        integerMap.put(r + 1, right);
                    }
                    if (l > left && r < left){
                        integerMap.put(left,right);
                    }
//                    if (left < l && right )

                }
            }
        }

        public int count() {
            return 0;
        }
    }
}
