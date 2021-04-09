package K442数组中重复的数据;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
class Solution {
    public static void main(String[] args) {

    }


    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<> ();
        ArrayList<Integer> list2 = new ArrayList<> ();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains ( nums[i] )){
                hashSet.add ( nums[i] );
            } else {
                list2.add ( nums[i] );
            }
        }
        return list2;
    }




}