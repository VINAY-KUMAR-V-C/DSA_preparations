package Patterns.OverLappingIntervals;

import java.util.Arrays;

public class EraseAndMakeNonOverLappingItervals_435_E {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res=0;
        int cur=1;
        int prev = 0;
        while(cur<intervals.length){
            if(intervals[cur][0]<intervals[prev][1]){
                res++;
                
            }else{
                prev=cur;
            }
            cur++;
        }
        return res;
    }
public static void main(String[] args) {
    new EraseAndMakeNonOverLappingItervals_435_E().eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
    //Answer:1
    //new EraseAndMakeNonOverLappingItervals_435_E().eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}});
    // answer : 2
}
}
