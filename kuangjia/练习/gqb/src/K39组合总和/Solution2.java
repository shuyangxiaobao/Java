package K39组合总和;

import java.lang.reflect.Array;
import java.util.*;

class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        Solution2 solution2 = new Solution2 ();
        List<List<Integer>> lists = solution2.combinationSum ( nums, 4 );
        System.out.println (lists);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<List<Integer>> list = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        combinationSum(candidates,target,0,list,path);

        ArrayList<List<Integer>> result = new ArrayList<> ();
        for (List<Integer> obj:list
             ) {
            obj.sort ( new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            } );
            if (!result.contains ( obj )){
                result.add ( new ArrayList<> ( obj ) );
            }

        }

        return result;
    }

    public void combinationSum(int[] candidates, int target,int sum, List<List<Integer>> list,List<Integer> path ) {
        if (sum == target){
//            path.sort ( new Comparator<Integer> () {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1-o2;
//                }
//            } );
            if (!list.contains ( path )){
                list.add ( new ArrayList<> ( path ) );
            }
            return;
        }
        if (sum > target){
            return;
        }
        int length = candidates.length;
        for (int i = 0; i < length; i++) {
            if (path.size () == 0 && sum == 1){
                System.out.println ("242324");
            }
            path.add ( candidates[i] );
            sum += candidates[i];
            combinationSum(candidates,target,sum,list,path);
            sum -= candidates[i];
            path.remove ( path.size()-1);
            if (path.size () == 0 ){
                System.out.println ("11111");
//                sum = 0;
            }

        }
    }


}