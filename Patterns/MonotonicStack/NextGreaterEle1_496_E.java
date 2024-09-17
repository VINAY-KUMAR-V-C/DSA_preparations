package Patterns.MonotonicStack;

import java.util.HashMap;
import java.util.Stack;

class NextGreaterEle1_496_E {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=nums2.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.add(nums2[i]);
                map.put(nums2[i],-1);
            }else{
                while(!stack.isEmpty() && stack.lastElement()<nums2[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.add(nums2[i]);
                    map.put(nums2[i],-1);
                }else{
                    map.put(nums2[i], stack.lastElement());
                    stack.add(nums2[i]);
                }
            }
        }
        for(int i=0;i<nums1.length;i++){
            nums1[0] = map.get(nums1[0]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        new NextGreaterEle1_496_E().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }
}