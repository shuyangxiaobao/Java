package K77组合;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public List<List<Integer>> combine(int n, int k) {

        ArrayList<List<Integer>> list = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        if (k > n){
            return list;
        }
        combine(n,k,list,path);
        return list;


    }

    public void combine(int n, int k,List<List<Integer>> list,List<Integer> path) {

       if (path.size () == k){
           list.add ( new ArrayList<> ( path ) );
       }
        for (int i = 0; i < n; i++) {
            if (path.contains ( i+1 )){
                continue;
            }
            if (path.size () > 1){
                if (path.get ( path.size ()-1 ) >= (i+1)){
                    continue;
                }
            }
            path.add ( i+1 );
            combine(n,k,list,path);
            path.remove ( path.size ()-1 );
        }
    }




}