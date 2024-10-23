package Patterns.MonotonicStack;

import java.util.Stack;

public class LargestRectangleInHistogram_84_M {
    int[] getLeftSmallest(int[] heights){
        int[] res = new int[heights.length];
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while(i<heights.length){
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                int cur = heights[i];
                while(!stack.isEmpty() && cur<=heights[stack.lastElement()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                }
                else{
                    res[i] = stack.lastElement();
                }
            }
            stack.add(i);
            i++;
        }
        return res;
    }
    int[] getRightSmallest(int[] heights){
        int[] res = new int[heights.length];
        int i = heights.length-1;
        Stack<Integer> stack = new Stack<>();
        while(i>=0){
            if(stack.isEmpty()){
                res[i] = heights.length;
            }else{
                int cur = heights[i];
                while(!stack.isEmpty() && cur<=heights[stack.lastElement()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = heights.length;
                }
                else{
                    res[i] = stack.lastElement();
                }
            }
            stack.add(i);
            i--;
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
       int[] leftSmallerEle = getLeftSmallest(heights);
       int[] rightSmallerEle = getRightSmallest(heights);
       int res = 0;
       for(int i=0;i<heights.length;i++){
            res = Math.max(res, (rightSmallerEle[i]-leftSmallerEle[i]-1)*heights[i]);
       }
       return res;
    }
    public static void main(String[] args) {
        new LargestRectangleInHistogram_84_M().largestRectangleArea(new int[]{0,1,0,1});
    }
}
