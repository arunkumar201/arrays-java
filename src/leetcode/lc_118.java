package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_118 {
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(List.of(1));
            return list;
        }
        List<List<Integer>> allRows = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.addFirst(1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allRows.add(new ArrayList<Integer>(row));
        }

        return allRows;
    }

    public static void main(String[] args) {
        int numRows = 5;
        var res = generate(numRows);
        System.out.println(res);
    }
}
