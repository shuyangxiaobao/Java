package K673最长递增子序列的个数;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int[] nums = {1,2,4,3,5,4,7,2};
        solution.findNumberOfLIS ( nums );

    }


    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length <= 1){
            return length;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max ( dp[i],dp[j]+1 );
                }
            }
            max = Math.max ( max,dp[i] );
        }

        int[] dp2 = new int[length];
        dp2[0] = 1;
        int index = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp2[j]+1 == max){
                        index++;
                    }
                    dp2[i] = Math.max ( dp2[i],dp2[j]+1 );
                } else if (nums[i] == nums[j]) {
                     if (dp2[j]== max){
                         index++;
                     }
                }
            }
        }

        return index;
    }




}