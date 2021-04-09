package K20有效的括号;


import java.util.Stack;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public boolean isValid(String s) {
        char[] arr = s.toCharArray ();
        int length = arr.length;
        Stack<Character> stack = new Stack<> ();
        for (int i = 0; i < length; i++) {
           if( isLeft ( arr[i] )){
                stack.push ( arr[i] );
            } else {
               Character ch = stack.pop ();
               if ((ch == '(' && arr[i] == ')') || (ch == '{' && arr[i] == '}') || (ch == '[' && arr[i] == ']')){

               } else {
                   return false;
               }
           }
        }

        return stack.isEmpty ();
    }

    public boolean isLeft(Character ch){
        if (ch == '(' || ch == '{' || ch == '['){
            return true;
        } else {
            return false;
        }
    }




}