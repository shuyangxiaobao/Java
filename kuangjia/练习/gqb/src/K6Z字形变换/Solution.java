package K6Z字形变换;


//
class Solution {
    public static void main(String[] args) {
        convert ( "PAYPALISHIRING",3 );

    }


   static public String convert(String s, int numRows) {
        int length = s.length ();
        if (length == 1){
            return s;
        }
        StringBuilder[] arr = new StringBuilder[numRows];
       for (int i = 0; i < numRows; i++) {
           arr[i] = new StringBuilder (  );
       }
        for (int i = 0; i < length; i++) {
            int index = i % (2 * numRows-2);
            if (index < numRows){
                arr[index].append ( s.charAt ( i )+"" );
            } else {
                arr[2*numRows-2-index].append ( s.charAt ( i )+"" );
            }
        }
        StringBuilder ans = new StringBuilder ();
        for (StringBuilder builder:arr
             ) {
            ans.append ( builder.toString () );
        }
       System.out.println (ans.toString ());
        return ans.toString ();
    }




}