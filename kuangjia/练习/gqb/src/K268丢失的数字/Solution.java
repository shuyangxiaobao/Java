package K268丢失的数字;


import java.util.Arrays;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

        int[] nums = {0,2,3};
        missingNumber(nums);
    }

//    O(n) 时间复杂度
    public int missingNumber2(int[] nums) {
        Arrays.sort ( nums );
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return 0;
    }
   static public int missingNumber(int[] nums) {
        Arrays.sort ( nums );
        int length = nums.length;
        if (nums[length -1] == length-1){
            return length;
        }

        int begin = 0;
        int end = nums.length-1;
        while(begin<end){
            int mid = (begin + end) >> 1;
            if (nums[mid]== mid){
                begin = mid+1;
            }else {
                end = mid;
            }
        }
        return begin;
    }





}