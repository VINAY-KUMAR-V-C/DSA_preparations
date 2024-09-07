class LongestSubArrayWithEqualNoOfOnesZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,1,0,0,0,0};
        System.out.println(logic1(arr));
    }

    static int logic1(int[] nums){
        int output = 0;
        int count=0;
        int len = nums.length;
        for(int i=0;i<len-1;i++){
            count = nums[i]==0?-1:+1;
            for(int j=i+1;j<len;j++){
                count += nums[j]==0?-1:+1;
                if(count==0){
                    output = Math.max(output,j-i+1);
                }
            }
        }
        return output;
    }
    static int logic2(int[] nums){
        int len = nums.length;
        int count = 0;
        int output = 0;
        for(int i=0;i<len;i++){
            count+=count==0?-1:+1;
            if(count==0){
                
            }
        }
    }
}