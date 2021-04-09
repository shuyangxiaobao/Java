package K216组合总和III;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        solution.combinationSum3 ( 3,7 );


    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> list = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        combinationSum3(k,n,0,list,path);
        return list;
    }

    public void combinationSum3(int k, int n,int sum,List<List<Integer>> list, List<Integer> path) {
        if (path.size () == k){
            if (sum == n){
                ArrayList<Integer> list1 = new ArrayList<> ( path );
                list1.sort ( new Comparator<Integer> () {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                } );
                if (!list.contains ( list1 )){
                    list.add ( list1 );
                }
            }
            return;
        }
        if (sum > n){
            return;
        }
        int i = 0;
        if (path.size () > 0){
            i = path.get ( path.size ()-1);
        }
        for (; i < 10; i++) {
            if(path.contains ( i )) continue;
            path.add ( i );
            sum += i;
            combinationSum3(k,n,sum,list,path);
            path.remove ( path.size ()-1 );
            sum -= i;
        }
    }




}