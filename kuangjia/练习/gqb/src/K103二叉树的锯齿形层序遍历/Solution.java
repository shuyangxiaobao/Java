package K103二叉树的锯齿形层序遍历;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<> ();
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        if (root == null){
            return lists;
        }
        queue.offer ( root );
        Boolean b1 = true;
        while (!queue.isEmpty ()){
            LinkedList<TreeNode> queue2 = new LinkedList<> ();
            ArrayList<Integer> list = new ArrayList<> ();
            while (!queue.isEmpty ()){
                TreeNode node = queue.poll ();
                if (b1){
                    list.add ( node.val );
                } else {
                    list.add ( 0,node.val );
                }
                if (node.left != null){
                    queue2.offer ( node.left );
                }
                if (node.right != null){
                    queue2.offer ( node.right );
                }
            }
            b1 = !b1;
            lists.add ( list );
            queue = queue2;
        }
        return lists;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        LinkedList<TreeNode> queue = new LinkedList<> ();
        if (root == null){
            return lists;
        }
        queue.offer ( root );
        Boolean b = true;
        while (!queue.isEmpty ()){
            LinkedList<TreeNode> queue2 = new LinkedList<> (  );
            List<Integer> list = new ArrayList<> (  );
            while (!queue.isEmpty ()){
                TreeNode node = queue.poll ();
                if (b){
                    list.add ( node.val );
                } else {
                    list.add ( 0,node.val );
                }
                if (node.left != null){
                    queue2.offer ( node.left );
                }
                if (node.right != null){
                    queue2.offer ( node.right );
                }
            }
            b = !b;
            lists.add ( list );
            queue = queue2;
        }
        return lists;
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