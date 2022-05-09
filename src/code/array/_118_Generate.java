package code.array;

import java.util.ArrayList;
import java.util.List;

public class _118_Generate {

    public static void main(String[] args) {
        _118_Generate app = new _118_Generate();
        List<List<Integer>> generate = app.generate(5);
        System.out.println("generate = " + generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> rowData;
        for (int i = 1; i <= numRows; i++) {
            rowData = new ArrayList<>(i);
            if (i == 1) {
                rowData.add(1);
                result.add(rowData);
            } else if (i == 2) {
                rowData.add(1);
                rowData.add(1);
                result.add(rowData);
            } else {
                rowData.add(1);
                for (int j = 1; j < i -1; j++) {
                    rowData.add(result.get(i-2).get(j-1) + result.get(i-2).get(j));
                }
                rowData.add(1);
                result.add(rowData);
            }
        }
        return result;
    }
}

