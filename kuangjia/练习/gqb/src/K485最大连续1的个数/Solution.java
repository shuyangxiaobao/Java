package K485最大连续1的个数;


import java.util.Arrays;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {



    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] == 1){
                dp[i] = dp[i-1]+1;
            } else {
                max = Math.max ( max,dp[i-1] );
            }
        }
        max = Math.max ( max,dp[length-1] );
        return max;
    }

}