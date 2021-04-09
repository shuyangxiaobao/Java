package 丑数II264;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        int i = nthUglyNumber ( 1000 );
        System.out.println (i);

    }

    static public int nthUglyNumber(int n) {
        if (n <= 10){
            switch (n){
                case 1:{
                    return 1;
                }
                case 2:{
                    return 2;
                }
                case 3:{
                    return 3;
                }
                case 4:{
                    return 4;
                }
                case 5:{
                    return 5;
                }
                case 6:{
                    return 6;
                }
                case 7:{
                    return 8;
                }
                case 8:{
                    return 9;
                }
                case 9:{
                    return 10;
                }
                case 10:{
                    return 12;
                }
                default:
            }

        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        dp[3] = 4;
        dp[4] = 5;
        dp[5] = 6;
        for (int i = 5; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j]*2 > dp[i-1]){
                    dp[i] = Math.min(dp[i],dp[j]*2);
                }
                if (dp[j]*3 > dp[i-1]){
                    dp[i] = Math.min(dp[i],dp[j]*3);
                }
                if (dp[j]*5 > dp[i-1]){
                    dp[i] = Math.min(dp[i],dp[j]*5);
                }
            }
        }
//        System.out.println (dp);
//        for (int i = 0; i < n; i++) {
//            System.out.println (dp[i]);
//        }
        return dp[n-1];
    }

}










