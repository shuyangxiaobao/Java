package 划分为k个相等的子集698;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};

        boolean b = canPartitionKSubsets ( nums, 4 );
        System.out.println (b);


    }


    static public boolean canPartitionKSubsets(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<> ();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            list.add ( nums[i] );
            sum += nums[i];
        }
        int aver = sum/k;
        if (aver*k != sum){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > aver){
                return false;
            } else if(nums[i] == aver){
                int index = list.indexOf ( nums[i] );
                list.remove ( index );
            } else {
                int index = list.indexOf ( nums[i] );
                list.remove ( index );
                if (!list.contains ( (aver-nums[i]) )){
                    return false;
                }
            }
        }

        return true;

    }

}










