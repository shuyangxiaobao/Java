package K40组合总和II;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution2 {


    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution2 solution2 = new Solution2 ();
        List<List<Integer>> lists = solution2.combinationSum2 ( arr, 27 );
        System.out.println (lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> list = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        int sum = 0;
        int length = candidates.length;

        for (int i = 0; i < length; i++) {
          sum += candidates[i];
        }
        if (sum < target){
            return list;
        }
        combinationSum2 ( candidates,target,0,list,path );
        return list;
    }

    public void combinationSum2(int[] candidates, int target,int sum,List<List<Integer>> list,
                                               List<Integer> path) {
        if (sum == target){
            int size = path.size ();
            ArrayList<Integer> temp = new ArrayList<> ();
            for (int i = 0; i < size; i++) {
                temp.add ( candidates[path.get ( i )] );
            }
            temp.sort ( new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            } );
            if (!list.contains ( temp )){
                list.add ( temp );
            }
            return ;
        }
        if (sum > target){
            return;
        }
        if (path.size () == candidates.length){
            return;
        }
        int length = candidates.length;
        for (int i = 0; i < length; i++) {
            if (path.contains ( i )) continue;
            path.add ( i );
            sum += candidates[i];
            combinationSum2 ( candidates,target,sum,list,path );
            sum -= candidates[i];
            path.remove ( path.size ()-1 );
        }

    }
}