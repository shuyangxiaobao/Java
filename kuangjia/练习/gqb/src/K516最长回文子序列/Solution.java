package K516最长回文子序列;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        solution.longestPalindromeSubseq ( "yyyuuioioiouuyyy" );

    }


    public int longestPalindromeSubseq(String s) {
        int length = s.length ();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (s.charAt ( i ) == s.charAt ( j ) ){
                    dp[j][i] = dp[j+1][i-1]+2;
                } else {
                    dp[j][i] = Math.max (dp[j+1][i],dp[j][i-1]);
                }
            }
        }
        return dp[0][length-1];
    }


//    public int longestPalindromeSubseq(String s) {
//        int length = s.length ();
//        int[][] dp = new int[length][length];
//        for (int i = 0; i < length; i++) {
//            dp[i][i] = 1;
//        }
//        for (int i = 1; i < length; i++) {
//            for (int j = i-1; j >= 0; j--) {
//                if (s.charAt ( i ) == s.charAt ( j ) ){
//                    if (i-j == 1){
//                        dp[j][i] = 2;
//                    } else {
//                        dp[j][i] = dp[j+1][i-1]+2;
//                    }
//                } else {
//                    if (i-j == 1){
//                        dp[j][i] = 1;
//                    } else {
//                        dp[j][i] = Math.max (dp[j+1][i],dp[j][i-1]);
//                    }
//                }
//                System.out.println ("dp["+j+"]["+i+"]"+" = "+dp[j][i]);
//            }
//        }
//        return dp[0][length-1];
//    }


//    public int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] f = new int[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            f[i][i] = 1;
//            for (int j = i + 1; j < n; j++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    f[i][j] = f[i + 1][j - 1] + 2;
//                } else {
//                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
//                }
//            }
//        }
//        return f[0][n - 1];
//    }



}