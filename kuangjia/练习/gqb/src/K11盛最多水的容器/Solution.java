package K11盛最多水的容器;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {


    }

    public int maxArea(int[] height) {

        int length = height.length;
        int left = 0;
        int right = length-1;
        int max = 0;
        while (left < right){
            int sum = Math.min (height[right],height[left])*(right-left);
            max = Math.max ( max, sum);
            if (height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }




}