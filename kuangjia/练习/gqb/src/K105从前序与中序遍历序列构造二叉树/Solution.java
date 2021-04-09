package K105从前序与中序遍历序列构造二叉树;


//https://leetcode-cn.com/problems/perfect-squares/
class Solution {

    public class TreeNode {
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




    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,5,1,6,3,7};
        Solution solution = new Solution ();
        TreeNode treeNode = solution.buildTree ( preorder, inorder );
        System.out.println (treeNode);

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int length = preorder.length;
        int length1 = inorder.length;
        if (length != length1){
            return null;
        }
        TreeNode node = buildTree ( preorder, inorder, 0, length - 1, 0, length - 1 );
        return node;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder,int p1,int p2,int o1,int o2) {
        if (p2 < p1){
            return null;
        }
        int val = preorder[p1];
        TreeNode root = new TreeNode ( val );
        if (p1 == p2){
            return root;
        }
        int index = 0;
        for (int i = o1; i <= o2; i++) {
            if (inorder[i] == val){
                index = i;
                break;
            }
        }
        int leftSize = index - o1;
        TreeNode left = buildTree ( preorder, inorder, p1 + 1, p1+leftSize, o1, o1+ leftSize-1 );
        TreeNode right = buildTree ( preorder, inorder, p1+leftSize+1,p2,index+1,o2 );
        root.left = left;
        root.right = right;
        return root;
    }

}