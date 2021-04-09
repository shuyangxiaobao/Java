package 三角形最小路径和120;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<> ();
        List<Integer> list0 = new ArrayList<> ();
        list0.add ( 2 );
        List<Integer> list1 = new ArrayList<> ();
        list1.add ( 3 );
        list1.add ( 4 );

        List<Integer> list2 = new ArrayList<> ();
        list2.add ( 6 );
        list2.add ( 5 );
        list2.add ( 7 );


        List<Integer> list3 = new ArrayList<> ();
        list3.add ( 4 );
        list3.add ( 1 );
        list3.add ( 8 );
        list3.add ( 3 );

        triangle.add ( list0 );
        triangle.add ( list1 );
        triangle.add ( list2 );
        triangle.add ( list3 );
        int total = minimumTotal ( triangle );
        System.out.println (total);



    }

   static public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size ();

        int[][] dp = new int[size][size];
       for (int i = 0; i < size; i++) {
           for (int j = 0; j < size; j++) {
               dp[i][j] = Integer.MAX_VALUE;
           }
       }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            List<Integer> list = triangle.get ( i );
            for (int j = 0; j < list.size (); j++) {
                if (i == 0){
                    dp[i][j] = list.get ( j );
                } else {
                    if (j == 0){
                        dp[i][j] = dp[i-1][j]+list.get ( j );
                    } else {
                        int a = Math.min (dp[i-1][j],dp[i-1][j-1])+list.get ( j );
                        dp[i][j] = a;
                    }
                }
                if (i == size -1){
                    min = Math.min ( min,dp[i][j] );
                }
            }
        }
        return min;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
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
                list.remove ( nums[i] );
            } else {
                list.remove ( nums[i] );
                if (!list.contains ( (aver-nums[i]) )){
                    return false;
                }
            }
        }

        return true;

    }

}










