package K72编辑距离;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int i = solution.minDistance ( "zoologicoarchaeologist", "zoogeologist" );
        System.out.println (i);

    }


    /**
     * 动态规划（二维数组）
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int row = word1.length ();
        int col = word2.length ();
        char[] arr1 = word1.toCharArray ();
        char[] arr2 = word2.toCharArray ();

        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <=row ; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <=col ; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {

                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]+1),dp[i][j-1]+1);
                } else {
                    dp[i][j] =  Math.min(Math.min(dp[i-1][j-1]+1,dp[i-1][j]+1),dp[i][j-1]+1);
                }
            }
        }
        return dp[row][col];
    }




}