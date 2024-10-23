package Patterns.OverLappingIntervals;

import java.util.ArrayList;
import java.util.Comparator;

//sort with first index and merge by comparing
public class MergeIntervals_56_E {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] i:intervals){
            list.add(i);
        }
        list.sort(new sortWithFirstInd());
        int i=1;
        while(i<list.size()){
            if(list.get(i)[0]<=list.get(i-1)[1]){
                int[] sub = list.remove(i);
                if(sub[1]<=list.get(i-1)[1]){
                    continue;
                }else{
                    list.set(i-1, new int[]{list.get(i-1)[0],sub[1]});
                }
            }else{
                i++;
            }
        }
        int[][] res = new int[list.size()][2];
        for(i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    class sortWithFirstInd implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]-o2[0];
        }
    }
    public static void main(String[] args) {
        new MergeIntervals_56_E().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}
