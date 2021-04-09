package K101对称二叉树;


import java.util.ArrayList;
import java.util.Stack;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        ArrayList<Integer> list = new ArrayList<> ();
        while (root != null || !stack.isEmpty ()){
            while (root != null){
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            list.add ( root.val );
            root = root.right;
        }
        int size = list.size ();
        int start = 0;
        int end = size-1;
        while (start < end){
            if (list.get ( start ) != list.get ( end )){
                return false;
            }
            start ++;
            end--;
        }
        return true;
    }



    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }





}