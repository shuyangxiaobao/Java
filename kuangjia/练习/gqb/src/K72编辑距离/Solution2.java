package K72编辑距离;


//
class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2 ();
        int i = solution.minDistance ( "zoologicoarchaeologist", "zoogeologist" );
        System.out.println (i);

    }


    /**
     * 动态规划（优化成一维数组）
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int row = word1.length ();
        int col = word2.length ();
        char[] arr1 = word1.toCharArray ();
        char[] arr2 = word2.toCharArray ();

        int[] dp = new int[col + 1];

        for (int i = 0; i <=col ; i++) {
            dp[i] = i;
        }

        int last = 0;
        for (int i = 1; i <= row; i++) {
            last = dp[0];
            dp[0] = i;
            for (int j = 1; j <= col; j++) {
                int temp = dp[j];
                if(arr1[i-1] == arr2[j-1]){
                    dp[j] = Math.min(Math.min(dp[j]+1,dp[j-1]+1),last);
                    last = temp;
                } else {
                    dp[j] = Math.min(Math.min(dp[j]+1,dp[j-1]+1),last+1);
                    last = temp;
                }
            }
        }
        return dp[col];
    }




}