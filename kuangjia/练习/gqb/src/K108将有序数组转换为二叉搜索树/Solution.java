package K108将有序数组转换为二叉搜索树;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }



    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        TreeNode node = sortedArrayToBST ( nums, 0, length - 1 );
        return node;

    }


    public TreeNode sortedArrayToBST(int[] nums,int start,int end) {
        if (start > end){
            return null;
        }
        if (start == end){
            return new TreeNode ( nums[start] );
        }
        int middle = (start + end) >> 1;
        TreeNode root = new TreeNode ( nums[middle] );
        root.left = sortedArrayToBST(nums,start,middle-1);
        root.right = sortedArrayToBST(nums,middle+1,end);
        return root;
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