package K333最大BST子树;


import java.util.LinkedList;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        TreeNode node10 = new TreeNode ( 10 );
        TreeNode node5 = new TreeNode ( 5);
        TreeNode node15 = new TreeNode ( 15 );
        TreeNode node1 = new TreeNode ( 1 );
        TreeNode node8 = new TreeNode ( 8 );
        TreeNode node7 = new TreeNode ( 7 );
        node10.left = node5;
        node10.right = node15;
        node5.left = node1;
        node5.right = node8;
        node15.right = node7;
        int i = solution.largestBSTSubtree ( node10 );
        System.out.println (i);

    }

    public Boolean isBST(TreeNode root){
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }

        TreeNode pred = null;
        if (root.left != null){
            pred = root.left;
            while (pred.right != null){
                pred = pred.right;
            }
        }
        TreeNode nextNode = null;
        if (root.right != null){
            nextNode = root.right;
            while (nextNode.left != null){
                nextNode = nextNode.left;
            }
        }
        boolean b1 = (pred != null ? root.val > pred.val : true) && (nextNode != null ? root.val < nextNode.val :
                true) &&
                isBST ( root.left ) && isBST ( root.right );
        return b1;
    }

    public int bstSize(TreeNode root){
        if (root == null){
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<> ();
        list.push ( root );
        int index = 0;
        while (!list.isEmpty ()){
            TreeNode node = list.pop ();
            index++;
            if (node.left != null){
                list.push ( node.left );
            }
            if (node.right != null){
                list.push ( node.right );
            }
        }
        return index;
    }




    public int largestBSTSubtree(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (isBST ( root )){
            return bstSize ( root );
        } else {
            return Math.max ( largestBSTSubtree ( root.left ),largestBSTSubtree ( root.right ) );
        }
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