package K217存在重复元素;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
//        int[] sum = containsDuplicate ( nums);
//        System.out.println (sum);





    }

   static public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2){
            return false;
        }
        Arrays.sort ( nums );
       int length = nums.length;
       for (int i = 1; i < length; i++) {
           if (nums[i] == nums[i -1]){
               return true;
           }
       }
       return false;
   }

}