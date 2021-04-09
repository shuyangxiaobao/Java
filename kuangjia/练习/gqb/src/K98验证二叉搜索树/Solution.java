package K98验证二叉搜索树;


import java.util.Stack;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }



//    public boolean isValidBST(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//        if (root.left == null && root.right == null){
//            return true;
//        }
//        TreeNode pred = null;
//        if (root.left != null){
//            pred = root.left;
//            while (pred.right != null){
//                pred = pred.right;
//            }
//        }
//        TreeNode nextNode = null;
//        if (root.right != null){
//            nextNode = root.right;
//            while (nextNode.left != null){
//                nextNode = nextNode.left;
//            }
//        }
//        boolean b1 = (pred != null ? root.val > pred.val : true) && (nextNode != null ? root.val < nextNode.val :
//                true) &&
//                isValidBST ( root.left ) && isValidBST ( root.right );
//        return b1;
//    }


    //    使用中序遍历
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        int last = 0;
        boolean b1 = false;
        while (root != null || !stack.isEmpty ()){
            while (root != null){
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            if(!b1){
                last = root.val;
                b1 = true;
            } else {
                if (root.val <= last){
                    return false;
                }
            }
            last = root.val;
            root = root.right;
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