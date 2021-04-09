package K236二叉树的最近公共祖先;


import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root|| q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor ( root.left, p, q );
        TreeNode right = lowestCommonAncestor ( root.right, p, q );
        if (left != null && right !=null){
            return root;
        }
      return left != null ? left : right;
    }


//    public List<Integer> demo(TreeNode root, TreeNode p){
//
//    }





    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }





}