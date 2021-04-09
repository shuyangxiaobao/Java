package K739每日温度;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] dp = new int[length];
        for (int i = length-2; i >= 0; i--) {
            int j = i+1;
            while (true){
                if (T[i]<T[j]){
                    dp[i] = j-i;
                    break;
                } else if(T[i]==T[j]){
                    if (dp[j] == 0){
                        dp[i] = 0;
                    } else {
                        dp[i] = dp[j]+(j-i);
                    }
                    break;
                } else {
                    if (dp[j] == 0){
                        dp[i] = 0;
                        break;
                    } else {
                        j = dp[j]+j;
                    }
                }
            }
        }
        return dp;
    }





}