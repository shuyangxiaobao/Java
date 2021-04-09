package K70爬楼梯;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public int climbStairs(int n) {
        if (n < 3){
            return 1;
        }
        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
           dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }




}