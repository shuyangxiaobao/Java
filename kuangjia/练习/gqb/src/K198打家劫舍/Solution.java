package K198打家劫舍;


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
        return dp[length-1];
    }



}