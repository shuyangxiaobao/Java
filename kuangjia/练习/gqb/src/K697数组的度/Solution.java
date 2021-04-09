package K697数组的度;


import java.util.Arrays;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {

    public static void main(String[] args) {

    }


    public int findShortestSubArray(int[] nums) {

        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort ( nums );

        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        int max2 = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]){
                dp[i] = dp[i-1]+1;
            }
            if (dp[i]> max){
                max = dp[i];
                max2 = nums[i];
            }
        }

        int min = 0;
        for (int i = 1; i < length; i++) {
           if (dp[i] == max2){
               min = Math.min ( min, calculate(nums,arr[i]));
           }
        }
        return min;
    }

    static public int calculate(int[] nums,int num){
        int length = nums.length;
        int begin = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == num){
                begin = i;
                break;
            }
        }
        int end = length-1;

        for (int i = length-1; i >= 0; i--) {
            if (nums[i] == num){
                end = i;
                break;
            }
        }
        return end-begin+1;
    }



}