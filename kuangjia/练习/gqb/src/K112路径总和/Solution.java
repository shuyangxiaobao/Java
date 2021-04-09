package K112路径总和;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();

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

    public void hasPathSum(TreeNode root, int sum,int target) {
        if (root == null){
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null){
            if (sum == target){
                exist = true;
                return;
            }
        }
        hasPathSum ( root.left,sum,target );
        hasPathSum ( root.right,sum,target );
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