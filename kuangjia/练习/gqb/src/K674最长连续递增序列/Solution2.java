package K674最长连续递增序列;


//https://leetcode-cn.com/problems/perfect-squares/
class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int length = findLengthOfLCIS ( nums );
        System.out.println (length);



    }


   static public int findLengthOfLCIS(int[] nums) {
       int length = nums.length;
       if (length <= 1){
           return length;
       }
       int[] dp = new int[length];
       dp[0] = 1;
       int max = 1;
       for (int i = 1; i < length; i++) {
           if (nums[i] > nums[i-1]){
               dp[i] = dp[i-1]+1;
           } else {
               dp[i] = 1;
           }
           max = Math.max ( max,dp[i] );
       }
       return max;
   }


}