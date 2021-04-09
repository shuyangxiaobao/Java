package K322零钱兑换;


import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int[] coins = {2};

        int i = solution.coinChange ( coins, 3 );
        System.out.println (i);

    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        Arrays.sort ( coins );
        int[] dp = new int[amount + 1];
        dp[0] = -1;
        for (int coin:coins) {
            if (amount >= coin){
                dp[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin:coins) {
                if (i<coin) continue;
                if (dp[i-coin] <= 0) continue;
                if (dp[i] == 0){
                    // 第一次
                    dp[i] = dp[i-coin]+1;
                } else {
                    dp[i] = Math.min ( dp[i],dp[i-coin]+1 );
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }


}