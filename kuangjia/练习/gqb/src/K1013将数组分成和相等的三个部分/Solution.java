package K1013将数组分成和相等的三个部分;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
//        int[] sum = twoSum ( nums, 9 );
//        System.out.println (sum);





    }

    public boolean canThreePartsEqualSum(int[] A) {
        int target = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum %3 !=0){
            return false;
        }
        target = sum/3;
         sum = 0;
         int count = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == target){
                count++;
                sum = 0;
            }
        }
        return count == 3;
    }

}