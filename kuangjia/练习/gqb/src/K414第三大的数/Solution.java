package K414第三大的数;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        int sum = thirdMax ( nums );
        System.out.println (sum);





    }


   static public int thirdMax(int[] nums) {
        Arrays.sort ( nums );
        int index = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] != nums[i+1]){
                index++;
                if (index == 3){
                    if (i == 0){
                        return nums[0];
                    }else {
                        if (nums[i] == nums[i-1]){
                            return nums[nums.length-1];
                        } else {
                            return nums[i];
                        }
                    }
                }
            }
        }
        return nums[nums.length-1];
    }

}