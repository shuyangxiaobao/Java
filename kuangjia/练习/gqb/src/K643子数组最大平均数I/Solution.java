package K643子数组最大平均数I;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums = {3,3,4,3,0};
        double maxAverage = findMaxAverage ( nums, 3 );
        System.out.println (maxAverage);
    }

    static public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        int[] dp = new int[length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        dp[0] = sum;
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] - nums[i-1]+nums[i+k-1];
            max = Math.max ( max,dp[i] );
        }
        return max*1.0/k;
    }
}