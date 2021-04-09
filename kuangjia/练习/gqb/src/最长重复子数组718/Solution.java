package 最长重复子数组718;

public class Solution {

    public static void main(String[] args) {
        int[] A = {0,1,1,1,1};
        int[] B = {1,0,1,0,1};

        int length = findLength ( A, B );
        System.out.println (length);

    }

//    最长重复子数组
   static public int findLength(int[] A, int[] B) {
       int a = A.length;
       int b = B.length;
       int[][] dp = new int[a][b];
       for (int i = 0; i < a; i++) {
           if (A[i] == B[0]){
               dp[i][0] = 1;
           }
       }
       for (int i = 0; i < b; i++) {
           if (B[i] == A[0]){
               dp[0][i] = 1;
           }
       }
       int max = 0;
       for (int i = 1; i < a; i++) {
           for (int j = 1; j < b; j++) {
               if (A[i] == B[j]){
                   dp[i][j] = dp[i-1][j-1] + 1;
               }
               max = Math.max ( max,dp[i][j] );
           }
       }

       return max;
    }



}





// 动态规划里面，如果题意可以连续，动态转移方程也是连续，不连续也是不连续。




