package K93复原IP地址;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        solution.restoreIpAddresses ( "0000" );

    }

    public List<String> restoreIpAddresses(String s) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        int length = s.length ();
        int sum = 0;
        restoreIpAddresses(length,lists,path,sum);
        ArrayList<String> result = new ArrayList<> ();

        int start = 0;
        for (List<Integer> list:lists
        ) {
            start = 0;
            Boolean valid = true;
            StringBuilder builder = new StringBuilder ();
            for (Integer index:list
            ) {
                String substring = s.substring ( start, start + index );
                if ((substring.length () > 1 && substring.charAt ( 0 ) != '0') && Integer.parseInt (substring) >= 0 && Integer.parseInt (substring) <= 255 || substring.length () == 1){
                    builder.append ( substring+"." );
                } else {
                    valid = false;
                    break;
                }
                start += index;
            }
            if (valid){
                String s1 = builder.toString ().substring ( 0, builder.length () - 1 );
                result.add ( s1 );
            }
        }

        return result;

    }


    public void restoreIpAddresses(int length,List<List<Integer>> lists,List<Integer> path,int sum) {
        if (path.size () == 4){
            if (sum == length){
                lists.add ( new ArrayList<> ( path ) );
            }
            return;
        }

        if (path.size () <= 2){
            int count = 0;
            for (int i = 0; i < path.size (); i++) {
                count += path.get ( i );
            }
            count += (4-path.size ())*3;
            if (count < length){
                return;
            }
        }

        for (int i = 1; i <= 3; i++) {
            sum += i;
            path.add ( i );
            restoreIpAddresses ( length,lists,path,sum );
            sum -= i;
            path.remove ( path.size ()-1 );
        }
    }


}