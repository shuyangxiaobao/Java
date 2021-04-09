package K1539第k个缺失的正整数;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/kth-missing-positive-number/submissions/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<> ();
        addElement ( 0,arr[0],list );
        if (list.size () >= k){
            return list.get ( k-1 );
        }
        int length = arr.length;
        for (int i = 1; i < arr.length; i++) {
            addElement ( arr[i-1],arr[i],list );
        }
        if (list.size () >= k){
            return list.get ( k-1 );
        } else {
            return k-list.size ()+arr[length-1];
        }
    }

    public void addElement(int begin, int end, List<Integer> list){
        for (int i = begin+1; i < end; i++) {
            list.add ( i );
        }
    }
}
