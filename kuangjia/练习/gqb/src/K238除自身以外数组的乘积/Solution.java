package K238除自身以外数组的乘积;


//
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] dp = productExceptSelf ( nums );
        System.out.println (dp);


    }

    static public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = nums[i-1]*dp[i-1];
        }

        int mul = 1;
        for (int i = length-2; i >= 0; i--) {
            mul *= nums[i+1];
            dp[i] = dp[i]*mul;
        }
        return dp;
    }




}