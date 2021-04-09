package K124二叉树中的最大路径和;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();

        TreeNode node10 = new TreeNode ( -10 );
        TreeNode node9 = new TreeNode ( 9 );
        TreeNode node20 = new TreeNode ( 20 );
        TreeNode node15 = new TreeNode ( 15 );
        TreeNode node7 = new TreeNode ( 7 );
        node10.left = node9;
        node10.right = node20;
        node20.left = node15;
        node20.right = node7;
        solution.maxPathSum2 ( node10 );


//        solution.

    }
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum2 ( root );
        return max;
    }




//    节点最大贡献值
    public int maxPathSum2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int sum = root.val;
        int left = 0;
        if (root.left != null) {
            left = Math.max ( maxPathSum2 ( root.left ),left );
        }
        int right = 0;

        if (root.right != null){
            right = Math.max ( maxPathSum2 ( root.right ),right );
        }
        max = Math.max (max,sum + left +right );
        return sum + Math.max (Math.max ( left,right ),0  );
    }




    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }





}