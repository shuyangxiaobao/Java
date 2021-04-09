package K40组合总和;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static LinkedList<List<Integer>> lists = new LinkedList<> ();
    static LinkedList<Integer> hashList = new LinkedList<> ();

    static int[] xlpcandidates;
    static int xlptarget;

    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        combinationSum2 ( arr,5 );
        System.out.println (lists);

    }


    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        xlpcandidates = candidates;
        xlptarget = target;

        LinkedList<Integer> list = new LinkedList<> ();
        demo1 ( 0,0, list);

        return lists;
    }


    static public List<Integer> demo1(int currentSum,int current,List<Integer> list){
        if(currentSum + current == xlptarget){
            LinkedList<Integer> list1 = new LinkedList<> ();
            for (int i = 0; i < list.size (); i++) {
                list1.add ( list.get ( i ) );
            }
            list1.add ( current );
            list1.sort ( new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            if (!hashList.contains ( list1.hashCode () )){
                lists.add ( list1 );
                hashList.add ( list1.hashCode () );
            }
            return list1;
        }
        if(currentSum + current < xlptarget){
            LinkedList<Integer> list1 = new LinkedList<> ();
            for (int i = 0; i < list.size (); i++) {
                list1.add ( list.get ( i ) );
            }
            if (current > 0){
                list1.add ( current );
                currentSum += current;
            }

            int[] xlpcandidates_temp = new int[xlpcandidates.length-list.size ()];

            LinkedList<Integer> xlpcandidates_tempList = new LinkedList<> ();
            for (int i = 0; i < xlpcandidates.length; i++) {
                xlpcandidates_tempList.add ( xlpcandidates[i] );
            }
            for (int i = 0; i < list1.size (); i++) {
                xlpcandidates_tempList.remove ( list1.get ( i ) );
            }


//            for (int i = 0; i < xlpcandidates_temp.length; i++) {
//                xlpcandidates_temp[i] = xlpcandidates[i+list.size ()];
//            }
            for (int i = 0; i < xlpcandidates_tempList.size (); i++) {
                demo1 (currentSum,xlpcandidates_tempList.get ( i ),list1);
            }
        }
        return list;
    }
}