package K33搜索旋转排序数组;


//
class Solution {
    public static void main(String[] args) {

    }



    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        int mid = (begin + end) >> 1;
        while (begin < end){
            if (nums[mid] > target && target > nums[begin]){

            }
        }
        return 0;
    }




}