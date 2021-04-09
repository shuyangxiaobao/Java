package K228汇总区间;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {

        int[] nums = {0,2,3,4,6,8,9};
        List<String> list = summaryRanges ( nums );
        System.out.println (list);
    }


    static public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<> ();
        int length = nums.length;
        int begin = 0;
        int end = 0;
        int maxEnd = 0;
        for (int i = 0; i < length-1; i++) {
            if (nums[i] == nums[i+1]-1){
                end = i+1;
                if (end == nums.length-1){
                    maxEnd = Math.max(maxEnd,end);
                    list.add ( demo ( begin,end,nums ) );
                }
            } else {
                list.add ( demo ( begin,end,nums ) );
                maxEnd = Math.max(maxEnd,end);
                begin = i+1;
                end = begin;
            }
        }
        if (maxEnd+1 == nums.length){
            return list;
        }else {
            list.add ( demo ( maxEnd+1,maxEnd+1,nums ) );
        }
        return list;
    }
    static public String demo(int begin,int end,int[] nums){
        if (begin == end){
            return nums[begin]+"";
        }else {
            return nums[begin]+"->"+nums[end];
        }
    }

}