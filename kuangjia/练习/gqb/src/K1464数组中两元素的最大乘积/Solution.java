package K1464数组中两元素的最大乘积;


import java.util.Arrays;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        Arrays.sort ( nums );
        int length = nums.length;
        return Math.max ( (nums[0]-1)*(nums[1]-1), (nums[length-2]-1)*(nums[length-1]-1));
    }




}