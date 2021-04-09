package K35搜索插入位置;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};

        searchInsert ( nums,2 );





    }

    static   public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (target > nums[length - 1]){
            return length;
        }

        int begin = 0;
        int end = length-1;
        int mid = (begin + end) >> 1;
        while (begin<end){
            mid = (begin + end) >> 1;
            if (nums[mid] > target){
                end = mid;
            }else if(nums[mid] < target){
                begin = mid+1;
            } else {
                return mid;
            }
        }
        return begin;
    }

}