package K653两数之和IV输入BST;


import java.util.*;

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


    }







    public boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<> ();
        return findtarget_sub ( hashSet,root,k );
    }

    public boolean findtarget_sub(HashSet<Integer>hashSet,TreeNode root,int k ){
        if (root == null){
            return false;
        }
        if (hashSet.contains ( k-root.val )){
            return true;
        }
        hashSet.add ( root.val );
        return findtarget_sub ( hashSet,root.left,k ) || findtarget_sub ( hashSet,root.right,k );
    }






//    public boolean findTarget(TreeNode root, int k) {
//        ArrayList<Integer> nums = new ArrayList<> ();
//        inorder ( root,nums );
//        int left = 0;
//        int right = nums.size ()-1;
//        while (left < right){
//            int sum = nums.get ( left ) + nums.get ( right );
//            if (sum < k){
//                left++;
//            } else if(sum > k){
//                right--;
//            }else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void inorder(TreeNode root,List<Integer> nums){
//
//        if (root == null){
//            return;
//        }
//        inorder ( root.left,nums );
//        nums.add ( root.val );
//        inorder ( root.right,nums );
//    }





}
