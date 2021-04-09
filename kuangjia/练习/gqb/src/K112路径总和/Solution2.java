package K112路径总和;


import jdk.nashorn.api.tree.Tree;

//
class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2 ();

        TreeNode node1 = new TreeNode ( 1 );
        TreeNode node2 = new TreeNode ( 2 );
        node1.left = node2;

        boolean b = solution.hasPathSum ( node1, 1 );
        System.out.println (b);

    }

    Boolean exist = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        int sum = 0;
        hasPathSum(root,0,targetSum);
        return exist;

    }

    public void hasPathSum(TreeNode root,int sum,int targetSum){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            if (targetSum == sum){
                exist = true;
                return;
            }
        }
        sum += root.val;
        hasPathSum ( root.left,sum ,targetSum);
        hasPathSum ( root.right,sum ,targetSum);
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