package K41缺失的第一个正数;


import java.util.ArrayList;
import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public int firstMissingPositive(int[] nums) {
        Arrays.sort ( nums );
        int length = nums.length;
        if(length == 0){
            return 1;
        }

        int a = nums[0];

        if (nums[length-1] < 0){
            return 1;
        }
        if (nums[0] > 1){
            return 1;
        }
        if(length == 1){
            return nums[0] +1;
        }

        ArrayList<Integer> list = new ArrayList<> ();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0){
                list.add ( nums[i] );
            }
        }
        int size = list.size ();
        if (list.get ( 0 ) > 1){
            return 1;
        }


        for (int i = 1; i < size; i++) {
           if (list.get ( i )-list.get ( i-1 ) > 1){
               return list.get ( i-1 )+1;
           }
        }
        return list.get ( size-1 ) + 1;
    }



}