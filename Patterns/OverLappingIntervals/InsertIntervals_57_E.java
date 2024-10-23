package Patterns.OverLappingIntervals;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertIntervals_57_E {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        boolean isAdded = true;
        for (int[] i : intervals) {
            if (newInterval[0] == i[0]) {
                list.add(new int[] { newInterval[0], Math.max(newInterval[1], i[1]) });
            } else if (isAdded && i[0] > newInterval[0]) {
                list.add(newInterval);
                isAdded = false;
                list.add(i);
            } else {
                list.add(i);
            }
        }
        list.add(newInterval);
        int i = 1;
        while (i < list.size()) {
            if (list.get(i)[0] <= list.get(i - 1)[1]) {
                int[] sub = list.remove(i);
                if (sub[1] <= list.get(i - 1)[1]) {
                    continue;
                } else {
                    list.set(i - 1, new int[] { list.get(i - 1)[0], sub[1] });
                }
            } else {
                i++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new InsertIntervals_57_E().insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
    }
}
