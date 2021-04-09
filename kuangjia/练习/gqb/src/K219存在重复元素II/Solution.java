package K219存在重复元素II;


import java.util.Arrays;
import java.util.HashSet;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
         containsNearbyDuplicate ( nums,2);
//        System.out.println (sum);





    }

   static public boolean containsNearbyDuplicate(int[] nums, int k) {
        int[] dp = new int[nums.length];
        HashSet<Object> hashSet = new HashSet<> ();

        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains ( nums[i] )){
                hashSet.add ( nums[i] );
            } else {
                dp[i] = 1;
                int distance = distance ( nums, nums[i] );
                if (distance <= k){
                    return true;
                }
            }
        }
        return false;
    }

    static public int distance(int[] nums,int a){
        int begin = -1;
        int min = Integer.MAX_VALUE;
        boolean b1 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a){
                if (begin>=0){
                    min = Math.min ( min,i-begin );
                }
                begin = i;
            }
        }
        return min;
    }


}