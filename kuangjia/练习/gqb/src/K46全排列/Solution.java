package K46全排列;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        int[] nums = {1,2,3};
        List<List<Integer>> lists = solution.permute ( nums );
        System.out.println (lists);
    }

//    public List<List<Integer>> permute(int[] nums) {
//        ArrayList<List<Integer>> lists = new ArrayList<> ();
//        int[] path = new int[nums.length];
//        permute ( nums,0 ,lists,path);
//
//        return lists;
//
//
//    }

//    public void permute(int[] nums,int index,List<List<Integer>> lists,int[] path) {
//
//        if (index == nums.length){
//            ArrayList<Integer> list = new ArrayList<> ();
//            for (int i = 0; i < nums.length; i++) {
//                list.add ( path[i] );
//            }
//            lists.add ( list );
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            path[index] = nums[i];
//            permute ( nums,index+1 ,lists,path);
//        }
//    }



//    回溯  dfs
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        permute ( nums,lists,path);
        return lists;
    }

    public void permute(int[] nums,List<List<Integer>> lists,List<Integer> path) {
        if (path.size () == nums.length){
            lists.add ( new ArrayList<> ( path ) );
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains ( nums[i] )){
                continue;
            }
            path.add ( nums[i] );
            permute ( nums ,lists,path);
            path.remove ( path.size ()-1 );
        }
    }



}