package K90子集II;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int[] nums = {9};
        List<List<Integer>> lists = solution.subsetsWithDup ( nums );
        System.out.println (lists);

    }



    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        subsetsWithDup ( nums,lists,path );
        ArrayList<List<Integer>> result = new ArrayList<> ();
        Arrays.sort ( nums );
        for (List<Integer> list:lists
             ) {
            ArrayList<Integer> temp = new ArrayList<> ();
            for (Integer index:list
                 ) {
                temp.add ( nums[index] );
            }
            temp.sort ( new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            } );
            if (!result.contains ( temp )){
                result.add ( temp );
            }
        }
        ArrayList<Integer> temp = new ArrayList<> ();
        result.add (temp);
        return result;
    }

    public void subsetsWithDup(int[] nums,List<List<Integer>> lists,List<Integer> path) {
        int length = nums.length;
        int i = 0;
        if (path.size () > 0){
            i = path.get ( path.size () -1 );
        }
        if (path.size () > 0 && i == nums.length -1){
            return;
        }
        for (; i < length; i++) {
            if (path.contains ( i )) continue;
            path.add ( i );
            lists.add ( new ArrayList<> ( path ) );
            subsetsWithDup ( nums,lists,path );
            path.remove ( path.size ()-1 );
        }

    }









}