package K113路径总和II;


import java.util.ArrayList;
import java.util.List;

//
class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2 ();
//        solution.

    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        ArrayList<Integer> path = new ArrayList<> ();
        pathSum (root, targetSum,0,lists,path );
        return lists;

    }

    public void pathSum(TreeNode root, int targetSum,int sum,List<List<Integer>> lists,
                        List<Integer> path ) {
        if (root == null){
            return;
        }
        sum += root.val;
        path.add ( root.val );
        if (root.left == null && root.right == null){
            if (sum == targetSum){
                lists.add ( new ArrayList<> ( path ) );
            }
        }
        if (root.left != null){
            pathSum ( root.left,targetSum,sum,lists,path );
            path.remove ( path.size ()-1 );

        }
        if (root.right != null){
            pathSum ( root.right,targetSum,sum,lists,path );
            path.remove ( path.size ()-1 );

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