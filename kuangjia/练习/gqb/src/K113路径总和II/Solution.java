package K113路径总和II;


import java.util.ArrayList;
import java.util.List;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
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
            return ;
        }
        path.add ( root.val );
        sum += root.val;
        if (root.left == null && root.right == null){
            if (targetSum == sum){
                lists.add ( new ArrayList<> ( path ) );
            }
        }
        pathSum(root.left,targetSum,sum,lists,path);
        if (root.left != null){
            path.remove ( path.size ()-1 );
        }

        pathSum(root.right,targetSum,sum,lists,path);
        if (root.right != null){
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