package K102二叉树的层序遍历;


import java.util.*;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


////层次遍历
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<> ();
//        queue.addLast ( root );
//        List<List<Integer>> lists = new LinkedList<> ();
//        if (root == null){
//            return lists;
//        }
//        while (!queue.isEmpty ()){
//            List<Integer> list = new LinkedList<> ();
//            LinkedList<TreeNode> queue2 = new LinkedList<> ();
//            while (!queue.isEmpty ()){
//                TreeNode node = queue.poll ();
//                list.add ( node.val );
//                if (node.left != null){
//                    queue2.add ( node.left );
//                }
//                if (node.right != null){
//                    queue2.add ( node.right );
//                }
//            }
//            lists.add ( list );
//            queue = queue2;
//        }
//        return lists;
//    }

//前序遍历（递归）
//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<> ();
//        preorderTraversal ( root,list );
//        return list;
//    }
//
//    public void preorderTraversal(TreeNode root,List<Integer> list) {
//        if (root == null){
//            return ;
//        }
//        list.add ( root.val );
//        preorderTraversal ( root.left,list );
//        preorderTraversal ( root.right,list );
//    }


////    前序遍历（迭代）
//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<> ();
//        Stack<TreeNode> stack = new Stack<> ();
//        if (root == null){
//            return list;
//        }
//        stack.push ( root );
//        while (!stack.isEmpty ()){
//            TreeNode node = stack.pop ();
//            list.add ( node.val );
//            if (node.right != null){
//                stack.push ( node.right );
//            }
//            if (node.left != null){
//                stack.push ( node.left );
//            }
//        }
//        return list;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        List<Integer> list = new ArrayList<> (  );
        if (root == null){
            return list;
        }
        stack.push ( root );
        while (!stack.isEmpty ()){
            root= stack.pop ();
            list.add ( root.val );
            if (root.right != null){
                stack.push ( root.right );
            }
            if (root.left != null){
                stack.push ( root.left );
            }
        }
        return list;
    }


//    中序遍历（迭代）
//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<> ();
//        Stack<TreeNode> stack = new Stack<> ();
//        while (root != null || !stack.isEmpty ()){
//            while (root != null){
//                stack.push ( root );
//                root = root.left;
//            }
//            root = stack.pop ();
//            list.add ( root.val );
//            root = root.right;
//        }
//        return list;
//    }



//    //    中序遍历（递归）
//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<> ();
//        inorderTraversal(root,list);
//        return list;
//    }
//
//    public void inorderTraversal(TreeNode root,List<Integer> list) {
//        if (root == null){
//            return;
//        }
//        inorderTraversal(root.left,list);
//        list.add ( root.val );
//        inorderTraversal(root.right,list);
//    }


//    二叉树的后序遍历（迭代）
    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<> ();
        List<Integer> list = new ArrayList<> (  );
        if (root == null){
            return list;
        }
        stack.push ( root );
        while (!stack.isEmpty ()){
            TreeNode node = stack.pop ();
            list.add ( 0,node.val );
            if (node.left != null){
                stack.push ( node.left );
            }
            if (node.right != null){
                stack.push ( node.right );
            }
        }
        return list;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        LinkedList<TreeNode> queue = new LinkedList<> ();
        if (root == null){
            return lists;
        }
        queue.offer ( root );
        while (!queue.isEmpty ()){
            LinkedList<TreeNode> queue2 = new LinkedList<> ();
            ArrayList<Integer> list = new ArrayList<> ();
            while (!queue.isEmpty ()){
                TreeNode node = queue.poll ();
                list.add ( node.val );
                if (node.left != null){
                    queue2.offer ( node.left );
                }
                if (node.right != null){
                    queue2.offer ( node.right );
                }
            }
            queue = queue2;
            lists.add ( list );
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