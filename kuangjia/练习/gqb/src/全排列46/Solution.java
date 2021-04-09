package 全排列46;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

//        for (int i = 0; i < 10; i++) {
//            arr[i] = i+1;
//        }


        System.out.println ("1111");

        List<List<Integer>> lists = permuteUnique ( arr );
        System.out.println ("23456789");
        System.out.println (lists);

    }

   static LinkedList<Integer> hashList = new LinkedList<> ();


    static public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> lists = new LinkedList<> ();
        LinkedList<Integer> temp = new LinkedList<Integer> ();
        int length = nums.length;
        if (length == 1){
            temp.add ( nums[0] );
            lists.add ( temp );
            return lists;
        }
        if (length == 0){
            return lists;
        }
        int[] nextArr = new int[length - 1];
        for (int i = 0; i < length-1; i++) {
            nextArr[i] = nums[i];
        }
        int last = nums[length -1];
        List<List<Integer>> nextList = permuteUnique ( nextArr );
        int size = nextList.size ();


        for (int i = 0; i < size; i++) {
            List<Integer> list = nextList.get ( i );
            for (int j = 0; j <= list.size (); j++) {
                List<Integer> list2 =  new LinkedList<Integer> (  );
                for (int k = 0; k < list.size (); k++) {
                    list2.add ( list.get ( k ) );
                }
                list2.add ( j, last);
                if (!hashList.contains ( list2.hashCode () )){
                    hashList.add ( list2.hashCode () );
                    lists.add ( list2 );
                }

            }
        }
        return lists;
    }
}







