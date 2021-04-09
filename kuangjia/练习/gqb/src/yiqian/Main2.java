package yiqian;

import java.util.*;

public class Main2 {


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode ( 1 );
//        yiqian.TreeNode node2 = new yiqian.TreeNode ( 2 );
//        yiqian.TreeNode node3 = new yiqian.TreeNode ( 3 );
//        node1.right = node2;
//        node2.left = node3;
//        List<Integer> list = preorderTraversal ( node1 );
//        System.out.println ( list.toString () );
//
        demo1 ();

    }


    //    前序遍历（递归  中左右）
    static public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<> ();
        if (root == null) {
            return list;
        }
        list.add ( root.val );

        List<Integer> list1 = preorderTraversal ( root.left );
        if (list1.size () > 0) {
            for (Integer a : list1
            ) {
                list.add ( a );
            }
        }
        List<Integer> list2 = preorderTraversal ( root.right );

        if (list2.size () > 0) {
            for (Integer a : list2
            ) {
                list.add ( a );
            }
        }
        return list;
    }

    //    前序遍历（迭代  中左右）用栈结构
    static public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        if (root == null) {
            return list;
        }
        stack.push ( root );
        while (!stack.isEmpty ()) {
            TreeNode node = stack.pop ();
            list.add ( node.val );
            if (node.right != null) {
                stack.push ( node.right );
            }
            if (node.left != null) {
                stack.push ( node.left );
            }
        }
        return list;
    }



    // 中序遍历（迭代） 用栈结构
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        while (root != null || !stack.isEmpty ()) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            list.add ( root.val );
            root = root.right;
        }
        return list;
    }

    // 中序遍历（迭代）
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        while (root != null || !stack.isEmpty ()) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            list.add ( root.val );
            root = root.right;
        }
        return list;


    }

    //    后序遍历（迭代  左右中）
    static public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        if (root == null) {
            return list;
        }
        stack.push ( root );
        while (!stack.isEmpty ()) {
            TreeNode node = stack.pop ();
            list.add ( 0, node.val );

            if (node.left != null) {
                stack.push ( node.left );
            }
            if (node.right != null) {
                stack.push ( node.right );
            }
        }
        return list;
    }


    //    层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer ( root );
        while (!queue.isEmpty ()) {
            ArrayList<Integer> list = new ArrayList<> ();
            Queue<TreeNode> queue2 = new LinkedList<> ();
            while (!queue.isEmpty ()) {
                TreeNode node = queue.poll ();
                list.add ( node.val );
                if (node.left != null) {
                    queue2.offer ( node.left );
                }
                if (node.right != null) {
                    queue2.offer ( node.right );
                }
            }
            queue = queue2;
            lists.add ( 0, list );
        }
        return lists;
    }


    //    226. 翻转二叉树(递归)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree ( root.left );
        TreeNode right = invertTree ( root.right );
        root.left = right;
        root.right = left;
        return root;
    }

    //    226. 翻转二叉树(非递归 使用了层次遍历)
    public TreeNode invertTree2(TreeNode root) {

        TreeNode result = root;
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer ( root );
        while (!queue.isEmpty ()) {
            Queue<TreeNode> queue2 = new LinkedList<> ();
            while (!queue.isEmpty ()) {
                TreeNode node = queue.poll ();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    queue2.offer ( node.left );
                }
                if (node.right != null) {
                    queue2.offer ( node.right );
                }
            }
            queue = queue2;
        }
        return result;
    }

    //104. 二叉树的最大深度（迭代）
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<> ();

        queue.offer ( root );
        int count = 0;
        while (!queue.isEmpty ()) {
            LinkedList<TreeNode> queue2 = new LinkedList<> ();
            count++;
            while (!queue.isEmpty ()) {
                TreeNode node = queue.poll ();
                if (node.left != null) {
                    queue2.offer ( node.left );
                }
                if (node.right != null) {
                    queue2.offer ( node.right );
                }
            }
            queue = queue2;

        }
        return count;
    }

    //104. 二叉树的最大深度（递归）
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = maxDepth2 ( root.left );
        int b = maxDepth2 ( root.right );
        if (a > b) {
            b = a;
        }
        return b + 1;

    }


    //    二叉树最大宽度
    static public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer ( root );
        ArrayList<Integer> list = new ArrayList<> ();
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<> ();
        list.add ( 1 );
        listAll.add ( list );
        while (!queue.isEmpty ()) {
            Queue<TreeNode> queue2 = new LinkedList<> ();
            ArrayList<Integer> list1 = listAll.get ( listAll.size () - 1 );
            ArrayList<Integer> list2 = new ArrayList<> ();
            int size = list1.size ();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                if (node.left != null) {
                    queue2.offer ( node.left );
                    int a = list1.get ( i );
                    list2.add ( 2 * a );
                }
                if (node.right != null) {
                    queue2.offer ( node.right );
                    int a = list1.get ( i );
                    list2.add ( 2 * a + 1 );
                }
            }
            queue = queue2;
            if (list2.size () > 0) {
                listAll.add ( list2 );
            }
        }
        System.out.println ( listAll );
        int max = 1;
        for (ArrayList<Integer> listTemp : listAll
        ) {
            int c = listTemp.get ( listTemp.size () - 1 ) - listTemp.get ( 0 ) + 1;
            if (c > max) {
                max = c;
            }
        }
        return max;
    }


    //    114. 二叉树展开为链表
    public void flatten(TreeNode root) {
        flatten2 ( root );
    }

    public TreeNode flatten2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = root;
        TreeNode left = flatten2 ( root.left );
        TreeNode right = flatten2 ( root.right );

        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
        return result;
    }


    //    106. 从中序与后序遍历序列构造二叉树

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        ArrayList<Integer> inorderList = new ArrayList<> ();
        ArrayList<Integer> postorderList = new ArrayList<> ();
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            inorderList.add ( inorder[i] );
        }

        for (int i = 0; i < length; i++) {
            postorderList.add ( postorder[i] );
        }

        return buildTree ( inorderList, postorderList );
    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if (postorder.size () == 0) {
            return null;
        }
        Integer val = postorder.get ( postorder.size () - 1 );
        TreeNode node = new TreeNode ( val );
        ArrayList<Integer> leftList1 = new ArrayList<> ();
        ArrayList<Integer> rightList1 = new ArrayList<> ();
        int size = inorder.size ();
        boolean b1 = false;
        for (int i = 0; i < size; i++) {
            Integer a = inorder.get ( i );
            if (a == val) {
                b1 = true;
            } else {
                if (b1) {
                    rightList1.add ( a );
                } else {
                    leftList1.add ( a );
                }
            }
        }
        ArrayList<Integer> leftList2 = new ArrayList<> ();
        ArrayList<Integer> rightList2 = new ArrayList<> ();
        for (int i = 0; i < size; i++) {
            Integer a = postorder.get ( i );
            if (leftList1.contains ( a )) {
                leftList2.add ( a );
            }
            if (rightList1.contains ( a )) {
                rightList2.add ( a );
            }
        }
        TreeNode left = buildTree ( leftList1, leftList2 );
        node.left = left;
        TreeNode right = buildTree ( rightList1, rightList2 );
        node.right = right;
        return node;
    }


    static void demo1() {
        int i = 10;
        int j = 3;

        System.out.println ( numPrimeArrangements ( 10 ) );
    }

    static public long numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean b = true;
            for (int j = 2; j <= i / 2; j++) {
                int a = i / j;
                if (a * j == i) {
                    b = false;
                    break;
                }
            }
            if (b) {
                count++;
            }
        }

        long a = 1;
        for (int i = 1; i <= count; i++) {
            a = a * i;
        }

        for (int i = 1; i <= n - count; i++) {
            a = a * i;
        }

        long c = a / 1000000000;
        return a;

    }

    //98. 验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int a = -Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<> ();
        boolean b = true;
        int last = 0;
        while (!stack.isEmpty () || root != null) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            if (b) {
                last = root.val;
            } else {
                if (root.val > last) {
                    last = root.val;
                } else {
                    return false;
                }
            }
            b = false;
            root = root.right;
        }
        return true;
    }

    //99. 恢复二叉搜索树
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<> ();
        ArrayList<Integer> list1 = new ArrayList<> ();
        ArrayList<Integer> list2 = new ArrayList<> ();
        TreeNode root1 = root;
        while (root != null || !stack.isEmpty ()) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            list1.add ( root.val );
            list2.add ( root.val );
            root = root.right;
        }

//排序
        int size = list1.size ();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (list1.get ( i ) > list1.get ( j )) {
                    int temp = list1.get ( i );
                    list1.set ( i, list1.get ( j ) );
                    list1.set ( j, temp );
                }
            }
        }

        int i = 0;
        root = root1;
        while (root != null || !stack.isEmpty ()) {
            while (root != null) {

                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            root.val = list1.get ( i++ );
            root = root.right;
        }
    }


    //    530. 二叉搜索树的最小绝对差

    public int getMinimumDifference(TreeNode root) {
        int last = 0;
        boolean b1 = true;
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<> ();
        while (!stack.isEmpty () || root != null) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            if (b1) {
                b1 = false;
            } else {
                if (root.val - last < min) {
                    min = root.val - last;
                }
            }
            last = root.val;
            root = root.right;
        }
        return min;
    }


    //    108. 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST2 ( nums, 0, nums.length - 1 );

    }

    static public TreeNode sortedArrayToBST2(int[] nums, int left, int right) {
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode ( nums[middle] );
        TreeNode leftNode = sortedArrayToBST2 ( nums, left, middle );
        TreeNode rightNode = sortedArrayToBST2 ( nums, middle, right );
        return root;
    }


    //938. 二叉搜索树的范围和

    public int rangeSumBST(TreeNode root, int L, int R) {

        Stack<TreeNode> stack = new Stack<> ();
        int result = 0;
        while (root != null || stack.isEmpty ()) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            if (root.val >= L && root.val <= R) {
                result += root.val;
            }
            root = root.right;
        }
        return result;


    }


    //235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode root1 = root;
        TreeNode root2 = root;
        ArrayList<Integer> list = new ArrayList<> ();
        while (root1 != null) {
            list.add ( root1.val );
            if (root1.val > p.val) {
                root1 = root1.left;
            }else if (root1.val < p.val){
                root1 = root1.right;
            } else {
                break;
            }
        }
        System.out.println(list);
        TreeNode result = null;
        while (root2 != null) {
            if (list.contains ( root2.val )){
                result = root2;
            }
            if (root2.val > q.val) {
                root2 = root2.left;
            }else if (root2.val < q.val){
                root2 = root2.right;
            } else {
                break;
            }
        }
        return result;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode root1 = root;
        TreeNode root2 = root;
        boolean b1 = false;
        boolean b2 = false;

        while (!b1 || !b2) {
            if (root1.val > p.val) {
                root1 = root1.left;
            }else if (root1.val < p.val){
                root1 = root1.right;
            } else {
                break;
            }
        }

        return null;
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

