package K230二叉搜索树中第K小的元素;


import java.util.Stack;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<> ();

        while (root != null || !stack.isEmpty ()){
            while (root != null){
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            k--;
            if (k == 0){
                return root.val;
            }
            root = root.right;
        }
        return 0;
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