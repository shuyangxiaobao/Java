package 最长递增子序列300;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

    }


//    最长递增子序列
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length < 2){
            return length;
        }
        int[] dp = new int[length];
        int max = 1;
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                   dp[i] = Math.max ( dp[i],dp[j]+1);
                }
            }
            max = Math.max ( max,dp[i] );
        }
        return max;
    }



}









