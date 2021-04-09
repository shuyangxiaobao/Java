package K654最大二叉树;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int length = nums.length;
        TreeNode treeNode = constructMaximumBinaryTree_sub ( nums, 0, length - 1 );
        return treeNode;

    }

    public TreeNode constructMaximumBinaryTree_sub(int[] nums,int begin,int end) {
        if (begin>end){
            return null;
        }
        if (begin == end){
            return new TreeNode (nums[end]);
        }
        int max = nums[begin];
        int maxindex = begin;
        for (int i = begin+1; i <= end; i++) {
            if (nums[i] > max){
                maxindex = i;
            }
        }
        TreeNode root = new TreeNode (max);
        TreeNode leftNOde = constructMaximumBinaryTree_sub ( nums, begin, maxindex - 1 );
        TreeNode rightNOde = constructMaximumBinaryTree_sub ( nums, maxindex+1, end );
        root.left = leftNOde;
        root.right = rightNOde;
        return root;
    }




}