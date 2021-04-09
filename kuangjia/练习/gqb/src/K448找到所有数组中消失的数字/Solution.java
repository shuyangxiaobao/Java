package K448找到所有数组中消失的数字;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers ( nums );
    }

    static public List<Integer> findDisappearedNumbers2(int[] nums) {
        Arrays.sort ( nums );
        int length = nums.length;
        ArrayList<Integer> list = new ArrayList<> ();
        for (int i = 1; i <= nums.length; i++) {
            list.add ( i );
        }
        for (int i = 0; i < length; i++) {
            int i1 = list.indexOf ( nums[i] );
            if (i1 >= 0){
                list.remove (i1);
            }
        }
        return list;
    }

    static public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort ( nums );
        int length = nums.length;
        ArrayList<Integer> list = new ArrayList<> ();
        HashSet<Integer> hashSet = new HashSet<> ();

        for (int i = 0; i < length; i++) {
           hashSet.add ( nums[i] );
        }
        for (int i = 1; i <= length; i++) {
            if (!hashSet.contains ( i)){
                list.add (i);
            }
        }
        return list;
    }





}