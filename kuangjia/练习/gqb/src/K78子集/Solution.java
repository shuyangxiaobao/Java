package K78子集;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static LinkedList<Integer> hashList = new LinkedList<> ();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets ( nums );
        System.out.println (lists);
    }
    static public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> lists = new LinkedList<> ();
        LinkedList<Integer> list = new LinkedList<> ();
        if (nums.length == 0){
            lists.add ( list );
            return lists;
        }
        if (nums.length == 1){
            list.add ( nums[0] );
            lists.add ( list );
            lists.add ( new LinkedList<> ());
            return lists;
        }

        int[] lastArr = new int[nums.length - 1];
        for (int i = 0; i < lastArr.length; i++) {
            lastArr[i] = nums[i];
        }
        List<List<Integer>> lastLists = subsets ( lastArr );
        for (int i = 0; i < lastLists.size (); i++) {
            lists.add ( lastLists.get ( i ) );
        }
        for (int i = 0; i < lastLists.size (); i++) {
            List<Integer> tempList = lastLists.get ( i );
            List<Integer> tempList2 = new LinkedList<Integer> (  );
            for (int j = 0; j < tempList.size (); j++) {
                tempList2.add ( tempList.get ( j) );
            }
            tempList2.add ( nums[nums.length-1] );

            tempList2.sort ( new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            } );


            if (!hashList.contains ( tempList2.hashCode () )){
                lists.add ( tempList2 );
                hashList.add (tempList2.hashCode ());
            }


        }
        return lists;

    }
}