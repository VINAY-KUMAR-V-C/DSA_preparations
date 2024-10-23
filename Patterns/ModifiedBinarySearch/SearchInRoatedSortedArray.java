package Patterns.ModifiedBinarySearch;

public class SearchInRoatedSortedArray {
    public int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int m = (i+j)/2;
            if(nums[m]==target){
                return m;
            }
            //check weather right is sorted else left will be sorted
            if(nums[m]>=nums[i]){
                if(target>nums[m] || target<nums[i]){
                    i = m+1;
                }else{
                    j=m-1;
                }
            }else{
                if(target>nums[j] || target<nums[m]){
                    j = m-1;
                }else{
                    i=m+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new SearchInRoatedSortedArray().search(new int[]{4,5,6,7,8,1,2,3}, 8);
        //new SearchInRoatedSortedArray().search(new int[] { 5, 1, 3 }, 5);
    }
}
