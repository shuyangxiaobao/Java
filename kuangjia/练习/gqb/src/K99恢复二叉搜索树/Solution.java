package K99恢复二叉搜索树;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    int index;

    public void recoverTree(TreeNode root) {

        if (root == null){
            return;
        }
        bianli ( root );


        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }


    public void bianli(TreeNode root) {
        if (root == null){
            return;
        }
        bianli ( root.left );
        if (prev != null && prev.val > root.val){
            index++;
            if (index == 1){
                first = prev;
                second = root;
            }
            if (index == 2){
                second = root;
            }
        }
        prev = root;
        bianli ( root.right );
    }








    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }





}