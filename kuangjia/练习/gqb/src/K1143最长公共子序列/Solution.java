package K1143最长公共子序列;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int i = solution.longestCommonSubsequence ( "123456", "345621" );
        System.out.println (i);

    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray ();
        char[] arr2 = text2.toCharArray ();
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[][] dp = new int[length2+1][length1+1];
        for (int i = 1; i <= length2; i++) {
            for (int j = 1; j <= length1; j++) {
                if (arr1[j-1] == arr2[i-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max ( dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int count = dp[length2][length1];
        String result = new String ();
        for (int i = length2; i >= 1; i--) {
            for (int j = length1; j >= 1; j--) {
                if (dp[i][j] == count && arr1[j-1] == arr2[i-1]){
                    result = arr1[j-1]+result;
                    count--;
                }
            }
        }
        System.out.println (result);
        return result.length ();
    }



}