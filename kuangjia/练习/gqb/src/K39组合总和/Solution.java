package K39组合总和;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<List<Integer>> lists = new LinkedList<> ();
    LinkedList<Integer> hashList = new LinkedList<> ();

    int[] xlpcandidates;
    int xlptarget;

    public static void main(String[] args) {
        int[] arr  = new int[2];



    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        xlpcandidates = candidates;
        xlptarget = target;

        LinkedList<Integer> list = new LinkedList<> ();
        demo1 ( 0,0, list);

        return lists;
    }


    public List<Integer> demo1(int currentSum,int current,List<Integer> list){
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

            for (int i = 0; i < xlpcandidates.length; i++) {
                demo1 (currentSum,xlpcandidates[i],list1);
            }
        }
        return list;


    }
}