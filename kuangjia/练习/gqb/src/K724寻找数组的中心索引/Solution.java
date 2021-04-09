package K724寻找数组的中心索引;


import java.util.concurrent.ConcurrentSkipListSet;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int index = pivotIndex ( nums );
        System.out.println (index);
    }

   static public int pivotIndex(int[] nums) {
        int sum = 0;
       int leftSum = 0;
       int length = nums.length;
       for (int i = 0; i < length; i++) {
           sum+=nums[i];
       }
       for (int i = 0; i < length; i++) {
           if (leftSum *2+nums[i] == sum){
               return i;
           }
           leftSum+=nums[i];
       }
       return -1;
    }




}