package K213打家劫舍;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length < 0){
            return 0;
        }
        if (length == 1){
            return nums[0];
        }
        if (length == 2){
            return Math.max ( nums[0],nums[1]);
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max ( nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max ( dp[i-1],nums[i]+dp[i-2] );
        }
        int a = dp[length - 2];

        int[] dp2 = new int[length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        dp2[2] = Math.max ( nums[1],nums[2]);
        for (int i = 3; i < length; i++) {
            dp2[i] = Math.max ( dp2[i-1],nums[i]+dp2[i-2] );
        }
        int b = dp2[length - 1];
        return Math.max ( a,b );
    }



}