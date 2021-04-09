package K46全排列;


import java.util.ArrayList;
import java.util.List;

//
class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2 ();
        int[] nums = {1,2,3};
        List<List<Integer>> lists = solution.permute ( nums );
        System.out.println (lists);
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        permute ( nums,lists,path );
        return lists;
    }

    public void permute(int[] nums, List<List<Integer>> lists,List<Integer> path) {
        if (nums.length == path.size ()){
            lists.add(new ArrayList<> ( path ));
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (path.contains ( nums[i] )) continue;
            path.add ( nums[i] );
            permute ( nums,lists,path );
            path.remove ( path.size ()-1 );
        }
    }




}