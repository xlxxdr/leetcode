package code.array;

import tools.Asserts;

import java.util.ArrayList;
import java.util.List;

public class _36_IsValidSudoku {

    public static void main(String[] args) {
        _36_IsValidSudoku app = new _36_IsValidSudoku();
        boolean result = app.isValidSudoku(new char[][]{
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
        Asserts.isTrue(result);
        result = app.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
        Asserts.isFalse(result);
        boolean result3 = app.isValidSudoku(new char[][]{
                 {'.', '.', '.', '.', '5', '.', '.', '1', '.'}
                , {'.', '4', '.', '3', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '3', '.', '.', '1'}
                , {'8', '.', '.', '.', '.', '.', '.', '2', '.'}
                , {'.', '.', '2', '.', '7', '.', '.', '.', '.'}
                , {'.', '1', '5', '.', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '2', '.', '.', '.'}
                , {'.', '2', '.', '9', '.', '.', '.', '.', '.'}
                , {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        });
        Asserts.isFalse(result3);
    }

    public boolean isValidSudoku(char[][] board) {
        List<Character> row = new ArrayList<>(9);
        List<Character> col = new ArrayList<>(9);
        List<Character> area = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                char rowValue = board[i][k];
                char colValue = board[k][i];
                if (rowValue != '.') {
                    if (row.contains(rowValue)) {
                        return false;
                    }
                    row.add(rowValue);
                }
                if (colValue != '.') {
                    if (col.contains(colValue)) {
                        return false;
                    }
                    col.add(colValue);
                }
                if ((i == 0 && (k % 3 == 0)) || (i == 3 && (k % 3 == 0)) || (i == 6 && (k % 3 == 0))) {
                    for (int j = 0; j <= 2; j++) {
                        for (int m = 0; m <= 2; m++) {
                            char areaValue = board[i + j][k + m];
                            if (areaValue != '.') {
                                if (area.contains(areaValue)) {
                                    return false;
                                }
                                area.add(areaValue);
                            }
                        }
                    }
//                    System.out.println("area = " + area);
                    area.clear();
//                    char c00 = board[i][k];
//                    char c10 = board[i + 1][k];
//                    char c20 = board[i + 2][k];
//                    char c01 = board[i][k + 1];
//                    char c11 = board[i + 1][k + 1];
//                    char c21 = board[i + 2][k + 1];
//                    char c02 = board[i][k + 2];
//                    char c12 = board[i + 1][k + 2];
//                    char c22 = board[i + 2][k + 2];
                }

            }
//            System.out.println("row = " + row);
//            System.out.println("col = " + col);
            row.clear();
            col.clear();

        }
        return true;
    }
}

