package K163缺失的区间;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> list = new ArrayList<> ();
        if (nums==null || nums.length == 0){
            list.add ( calculate ( lower-1,upper+1 ) );
            return list;
        }
            if (nums[0]>lower){
            list.add ( calculate ( lower-1,nums[0] ) );
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1] > 1){
                list.add ( calculate ( nums[i-1],nums[i] ) );
            }
        }
        int length = nums.length;
        if (nums[length-1]<upper){
            list.add ( calculate ( nums[length-1],upper+1 ) );
        }
        return list;
    }

    public String calculate(int begin,int end){
        if (end-begin > 2){
            begin++;
            end--;
            return begin+"->"+end;
        }
        begin++;
        return begin+"";
    }




}