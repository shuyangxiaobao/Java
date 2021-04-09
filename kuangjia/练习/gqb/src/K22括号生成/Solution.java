package K22括号生成;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        Boolean valid = solution.isValid ( "(())(())" );
        System.out.println (valid);

    }

    public List<String> generateParenthesis(int n) {

        List<String> lists = new ArrayList<> ();
        List<String> path = new ArrayList<> ();

        generateParenthesis(n,lists,path);
        return lists;
    }

    public void generateParenthesis(int n,List<String> lists,List<String> path) {

        if (path.size () == 2 * n){
            int count = 0;
            for (int i = 0; i < 2 *n; i++) {
                if (path.get ( i ).equals ( "(" )){
                    count++;
                }
            }
            if (count == n){
                StringBuilder builder = new StringBuilder ();
                for (int i = 0; i < 2 *n; i++) {
                    builder.append ( path.get ( i ) );
                }
                if (isValid ( builder.toString () )){
                    lists.add ( builder.toString () );
                }
            }
            return ;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0){
                path.add ( "(" );
            } else {
                path.add ( ")" );
            }
            generateParenthesis ( n,lists,path );
            path.remove ( path.size ()-1 );
        }
    }





    public Boolean isValid(String str){
        Stack<Object> stack = new Stack<> ();
        char[] array = str.toCharArray ();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] == '('){
              stack.push ( "(" );
            } else if(array[i] == ')'){
                if (stack.isEmpty ()){
                    return false;
                } else {
                 stack.pop ();
                }
            }
        }
        return stack.isEmpty ();
    }





}