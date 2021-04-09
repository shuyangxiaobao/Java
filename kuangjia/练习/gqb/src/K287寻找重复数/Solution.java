package K287寻找重复数;


import java.util.Arrays;
import java.util.HashSet;

//
class Solution {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        Arrays.sort ( nums );
        int begin = 0;
        int end = nums.length-1;
        while (begin < begin){
            int mid = (begin + end) >> 1;
            if (nums[mid] == mid){
                end = mid-1;
            } else{
                begin = mid;
            }
        }
        return nums[begin];
    }

    public int findDuplicate2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<> ();
        for (Integer num:nums
             ) {
            if (!hashSet.contains ( num )){
                hashSet.add ( num );
            } else {
                return num;
            }
        }
        return 0;
    }




}