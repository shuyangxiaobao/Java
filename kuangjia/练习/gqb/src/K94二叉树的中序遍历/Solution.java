package K94二叉树的中序遍历;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
        TreeNode node1 = new TreeNode ( 1 );
        TreeNode node2 = new TreeNode ( 2 );
        TreeNode node3 = new TreeNode ( 3 );
        node1.right = node2;
        node2.left = node3;


        List<Integer> list1 = solution.inorderTraversal ( node1 );
        System.out.println (list1);

    }



//    使用递归排序
//    List<Integer> list;
//    public List<Integer> inorderTraversal(TreeNode root) {
//        list = new ArrayList<Integer> ( );
//        inorder (root  );
//        return list;
//    }
//    public void inorder(TreeNode root) {
//        if (root == null){
//            return;
//        }
//        inorder ( root.left );
//        list.add ( root.val );
//        inorder ( root.right );
//    }
//

//使用迭代排序(中序排序)
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        while (root != null || !stack.isEmpty ()){
            while (root != null){
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            list.add ( root.val );
            root =  root.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        while (root != null || !stack.isEmpty ()){
            while (root != null){
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            list.add ( root.val );
            root = root.right;
        }
        return list;
    }








    }

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}