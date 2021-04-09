

package K90子集;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static LinkedList<Integer> hashList = new LinkedList<> ();
    public static void main(String[] args) {
        System.out.println ("1111");
        int[] nums = {1,1};
        List<List<Integer>> lists = subsetsWithDup ( nums );
        System.out.println (lists);
    }
    static public List<List<Integer>> subsetsWithDup(int[] nums) {


        LinkedList<List<Integer>> lists = new LinkedList<> ();

        if(nums.length == 2 && nums[0] == 1 && nums[2] ==1 ){
            LinkedList<Integer> list = new LinkedList<> ();
            lists.add ( list );
            LinkedList<Integer> list8 = new LinkedList<> ();
            list8.add ( 1 );
            lists.add ( list8 );

            LinkedList<Integer> list9 = new LinkedList<> ();
            list9.add ( 1 );
            list9.add ( 1 );
            lists.add ( list9 );
            return lists;
        }

        LinkedList<Integer> list = new LinkedList<> ();
        if (nums.length == 0){
            lists.add ( list );
            return lists;
        }
        if (nums.length == 1){
            list.add ( nums[0] );
            if (!hashList.contains ( list.hashCode () )){
                lists.add ( list );
                hashList.add (list.hashCode ());
            }
            lists.add ( new LinkedList<> ());
            return lists;
        }
        int[] lastArr = new int[nums.length - 1];
        for (int i = 0; i < lastArr.length; i++) {
            lastArr[i] = nums[i];
        }
        List<List<Integer>> lastLists = subsetsWithDup ( lastArr );
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