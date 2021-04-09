package K279完全平方数;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

        int i = numSquares ( 12 );
        System.out.println (i);
    }


   static public int numSquares(int n) {

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i-j*j >= 0; j++) {
                dp[i] = Math.min ( dp[i-j*j]+1,dp[i] );
            }
        }
        return dp[n];
    }
}