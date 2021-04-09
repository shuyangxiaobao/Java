package K16最接近的三数之和;


import java.util.Arrays;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        int i = threeSumClosest ( nums, -1 );
        System.out.println (i);


    }

   static public int threeSumClosest(int[] nums, int target) {
       Arrays.sort ( nums );
        int length = nums.length;
        int result = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < length-2; i++) {
            int left = i+1;
            int right = length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (Math.abs ( sum-target ) < Math.abs ( result-target )){
                    result = sum;
                }
                if (sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else {
                    return target;
                }
            }
        }
        return result;
    }



}