package K315计算右侧小于当前元素的个数;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public List<Integer> countSmaller(int[] nums) {

        ArrayList<Integer> list = new ArrayList<> ();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Integer count = countSmaller ( nums, i );
            list.add ( count );
        }

        return list;

    }

    public Integer countSmaller(int[] nums,int index) {
        int length = nums.length;
        int count = 0;
        for (int i = index+1; i < length; i++) {
            if (nums[index] > nums[i]){
                count++;
            }
        }
        return count;
    }







    }