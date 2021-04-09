package K1287有序数组中出现次数超过25的元素;


//https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
class Solution {
    public static void main(String[] args) {

    }


    public int findSpecialInteger(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 1;
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]){
                dp[i] = dp[i-1]+1;
            }else {
                dp[i] = 1;
            }
            if (dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }




}