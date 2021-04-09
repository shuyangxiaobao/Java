package K5最长回文子串;


//
class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2 ();
        String s = solution.longestPalindrome ( "aacabdk" );
        System.out.println (s);
    }


    //    动态规划(优化为一纬数组)
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray ();
        int length = array.length;
        Boolean[] dp = new Boolean[length];
        int max = 0;
        String s1 = new String ();

        Boolean last = false;
        for (int i = 0; i < length; i++) {
            dp[i] = true;
            for (int j = i; j < length; j++) {
                Boolean temp = dp[j];
                if (j-i <= 2){
                    if (array[i] == array[j]){
                        dp[j] = true;
                    } else {
                        dp[j] = false;
                    }
                } else {
                    if (array[i] == array[j]){
                        dp[j] = last;
                    } else {
                        dp[j] = false;
                    }
                }
                last = temp;
                if (dp[j]){
                    if (j-i >= max){
                        max = j-i;
                        s1 = s.substring ( i,j+1 );
                    }
                }
            }
        }
        return s1;
    }
}