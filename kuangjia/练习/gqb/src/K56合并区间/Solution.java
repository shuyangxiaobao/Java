package K56合并区间;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

    }



    public int[][] merge(int[][] intervals) {
        Arrays.sort ( intervals, new Comparator<int[]> () {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        } );
        ArrayList<int[]> list = new ArrayList<> ();
        list.add ( intervals[0] );
        int length = intervals.length;
        for (int i = 1; i < length; i++) {
            int[] arr = intervals[i];
            int[] lastArr = list.get ( list.size () - 1 );
            if (arr[0] > lastArr[1]){
                list.add ( arr );
            } else {
                lastArr[1] = Math.max ( lastArr[1],arr[1] );
            }
        }
        return list.toArray (new int[list.size ()][2]);
    }







}