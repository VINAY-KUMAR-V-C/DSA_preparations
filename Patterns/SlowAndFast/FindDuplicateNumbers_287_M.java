//convert array to LL and check cycle
package Patterns.SlowAndFast;

class FindDuplicateNumbers_287_M {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if(fast==slow){
                break;
            }
        }    
        fast = 0;    
        //floyds algo : start slow from where cycle found and start the fast from 0 with one step
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if(slow==fast){
                return slow;
            }
        }
    }

    public static void main(String[] args) {
        //ans : 2
        System.out.println(new FindDuplicateNumbers_287_M().findDuplicate(new int[]{1,3,4,2,2}));
        //ans : 3
        System.out.println(new FindDuplicateNumbers_287_M().findDuplicate(new int[]{3,3,3}));
    }
}