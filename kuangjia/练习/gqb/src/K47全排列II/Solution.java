package K47全排列II;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int[] nums = {1,2,3};
        List<List<Integer>> lists = solution.permuteUnique ( nums );
        System.out.println (lists);


    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        permuteUnique ( nums,lists,path );
        ArrayList<List<Integer>> results = new ArrayList<> ();
        for (List<Integer> list:lists) {
            ArrayList<Integer> temp = new ArrayList<> ();

            for (Integer index:list
                 ) {
                temp.add ( nums[index] );
            }
            if (!results.contains ( temp )){
                results.add ( temp );
            }
        }
        return results;
    }

    public void permuteUnique(int[] nums,List<List<Integer>> lists,List<Integer> path) {
        if (path.size () == nums.length){
            lists.add ( new ArrayList<> ( path ) );
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (path.contains ( i )) continue;
            path.add ( i );
            permuteUnique ( nums,lists,path );
            path.remove ( path.size ()-1 );
        }

    }




}