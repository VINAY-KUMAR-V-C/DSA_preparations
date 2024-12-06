package Patterns.DP;

public class LongestIncreasingSubSeq_300_M {
    public int lengthOfLIS(int[] nums) {
        int least = nums[0];
        int min = nums[0];
        int prev = nums[0];
        int curCount = 1;
        int finalRes = Integer.MIN_VALUE;
        int i=0;
        while(i<nums.length){
            int curEle = nums[i];
            if(curEle>prev){
                min = prev;
                prev = curEle;
                curCount++;
            }else if(curEle<prev && curEle<least){
                finalRes = Math.max(finalRes, curCount);
                curCount=1;
                least = curEle;
                min = curEle;
                prev = curEle;
            }else if(curEle<prev && curEle>min){
                prev = curEle;
            }
            finalRes = Math.max(finalRes, curCount);
            i++;
        }
        return finalRes;
    }
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubSeq_300_M().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); //Ans:4
        //System.out.println(new LongestIncreasingSubSeq_300_M().lengthOfLIS(new int[]{0,1,0,3,2,3})); //Ans:4
        //System.out.println(new LongestIncreasingSubSeq_300_M().lengthOfLIS(new int[]{7,7,7,7,7,7,7})); //Ans:1
        //System.out.println(new LongestIncreasingSubSeq_300_M().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6})); //Ans:6

    }
}
