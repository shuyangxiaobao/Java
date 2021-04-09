package K300最长递增子序列;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int[] nums = {10,9,2,5,3,7,101,18};
        int i = solution.lengthOfLIS ( nums );
        System.out.println (i);

    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max ( dp[i],dp[j]+1 );
                }

            }
            max = Math.max ( max,dp[i] );
        }
        return max;
    }




}