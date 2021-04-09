package K0算法面试题汇总.N;


import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int majorityElement(int[] nums) {
        Arrays.sort ( nums );
        int length = nums.length;
        return nums[length/2];
    }




}