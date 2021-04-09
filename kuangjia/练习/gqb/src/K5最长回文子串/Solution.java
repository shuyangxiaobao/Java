package K5最长回文子串;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        String s = solution.longestPalindrome ( "babad" );
        System.out.println (s);
    }


//    动态规划(二纬数组)
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray ();
        int length = array.length;
        Boolean[][] dp = new Boolean[length][length];
        int max = 0;
        String s1 = new String ();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i-j <= 2){
                    if (array[i] == array[j]){
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = false;
                    }
                } else {
                    if (array[i] == array[j]){
                        dp[j][i] = dp[j+1][i-1];
                    } else {
                        dp[j][i] = false;
                    }
                }
                if (dp[j][i]){
                    if (i-j > max){
                        max = i-j;
                        s1 = s.substring ( j,i+1 );
                    }
                }
            }
        }
        return s1;
    }




}