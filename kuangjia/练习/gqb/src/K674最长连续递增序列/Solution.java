package K674最长连续递增序列;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int length = findLengthOfLCIS ( nums );
        System.out.println (length);



    }


   static public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if(length == 1){
            return 1;
        }
        int index = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i]>nums[i-1]){
                index++;
                max = Math.max ( index,max );
            }  else {
                index = 1;
            }
        }
        max = Math.max ( index,max );
        return max;
    }


}