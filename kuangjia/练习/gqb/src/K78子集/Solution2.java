package K78子集;

import java.util.*;

class Solution2 {
    static LinkedList<Integer> hashList = new LinkedList<> ();

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        Solution2 solution2 = new Solution2 ();
        List<List<Integer>> list = solution2.subsets ( nums );
        System.out.println (list);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        Arrays.sort ( nums );
        subsets(nums,lists,path);
        return lists;
    }

    public void subsets(int[] nums,List<List<Integer>> lists,List<Integer> path) {
        if (path.size () > 0 && (path.get ( path.size ()-1 ) == nums [nums.length-1])){
            ArrayList<Integer> list = new ArrayList<> ( path );
                lists.add ( list );
            return;
        }
        ArrayList<Integer> list = new ArrayList<> ( path );
        lists.add ( list );

        int i = 0;
        if (path.size () > 0){
            for (int j = path.size (); j < nums.length; j++) {
                if (nums[j] == path.get ( path.size ()-1 )){
                    i = j;
                    break;
                }
            }
        }


        for (; i < nums.length; i++) {
            if (path.contains ( nums[i] )) continue;
            path.add ( nums[i] );
            subsets(nums,lists,path);
            path.remove ( path.size ()-1 );
        }
    }


}