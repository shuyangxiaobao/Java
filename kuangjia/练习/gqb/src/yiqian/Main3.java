package yiqian;

import java.util.*;

public class Main3 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public static void main(String[] args) {
        demo1 ();
    }

    static void demo1() {

    }

    //    589. N叉树的前序遍历
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<> ();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<> ();
        stack.push ( root );
        while (!stack.isEmpty ()) {
            Node node = stack.pop ();
            list.add ( node.val );
            List<Node> children = node.children;
            int size = children.size ();
            for (int i = size - 1; i >= 0; i--) {
                stack.add ( children.get ( i ) );
            }
        }
        return list;
    }

    //  590. N叉树的后序遍历 (基于前序遍历   中左右 =》 中右左 =》 左右中)
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<> ();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<> ();
        stack.push ( root );
        while (!stack.isEmpty ()) {
            Node node = stack.pop ();
            list.add ( 0, node.val );
            List<Node> children = node.children;
            int size = children.size ();
            for (int i = 0; i < size; i++) {
                stack.add ( children.get ( i ) );
            }
        }
        return list;
    }


    // 前中后序遍历使用栈结构 层次遍历使用队列解决
//    559. N叉树的最大深度(迭代)

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<Node> queue = new LinkedList<> ();
        queue.offer ( root );
        while (!queue.isEmpty ()) {
            Queue<Node> queue2 = new LinkedList<> ();
            while (!queue.isEmpty ()) {
                Node node = queue.poll ();
                List<Node> children = node.children;
                int size = children.size ();
                for (Node tempNode :
                        children) {
                    queue2.offer ( tempNode );
                }
            }
            queue = queue2;
            count++;
        }
        return count;

    }

    //    559. N叉树的最大深度(递归)
    static public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        List<Node> children = root.children;
        for (Node node : children
        ) {
            int maxDepth = maxDepth2 ( node );
            if (maxDepth > max) {
                max = maxDepth;
            }
        }
        return max + 1;
    }

    public String removeVowels(String S) {
        char[] chars = S.toCharArray ();
        int length = chars.length;
        StringBuilder stringBuilder = new StringBuilder ();
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if (c == 'a' || c == 'e'
                    || c == 'i'
                    || c == 'o'
                    || c == 'u') {

            } else {
                stringBuilder.append ( c );
            }
        }
        return stringBuilder.toString ();
    }


    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int a = 0;
        for (int i = 0; i < length; i++) {
            a += nums[i];
            result[i] = a;
        }
        return result;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int fist = matrix[0][0];
        int last = matrix[m - 1][n - 1];
        int a = 0;
        int b = 0;

        if (target < fist || target > last) {
            return false;
        }

        while (!((m - a == 1) || (n - b == 1))) {

            int middle = matrix[((m + a) / 2)][(b + n) / 2];
            if (target > middle) {
                a = (m + a) / 2;
                b = (b + n) / 2;
            } else if (target > middle) {
                m = (m + a) / 2;
                n = (b + n) / 2;
            } else {
                return true;
            }
        }

        for (int i = a; i <= m; i++) {
            for (int j = b; j <= n; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;

    }

    public TreeNode convertBiNode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        Queue<TreeNode> queue = new LinkedList<> ();
        while (root != null || !stack.isEmpty ()) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            queue.offer ( root );
            root = root.right;
        }
        TreeNode result = queue.poll ();
        root = result;
        while (!queue.isEmpty ()) {
            root.right = queue.poll ();
            root.left = null;
        }
        return result;

    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        Stack<TreeNode> stack = new Stack<> ();
        stack.push ( root1 );
        while (!stack.isEmpty ()) {
            TreeNode node = stack.pop ();
            boolean b = kk ( root2, target - node.val );
            if (b) {
                return b;
            }
            if (node.right != null) {
                stack.push ( node.right );
            }
            if (node.left != null) {
                stack.push ( node.left );
            }
        }
        return false;

    }

    static boolean kk(TreeNode root, int target) {

        while (root != null) {
            if (root.val > target) {
                root = root.left;
            } else if (root.val < target) {
                root = root.right;
            } else {
                return true;
            }
        }
        return false;
    }


    public TreeNode balanceBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        ArrayList<TreeNode> list = new ArrayList<> ();
        while (root != null || !stack.isEmpty ()) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            list.add ( root );
            root = root.right;
        }
        return balanceBST2 ( list, 0, list.size () - 1 );
    }

    //    取出中间节点
    static public TreeNode balanceBST2(ArrayList<TreeNode> list, int begin, int end) {
        if (begin == end) {
            return list.get ( begin );
        }
        if (begin > begin) {
            return null;
        }

        TreeNode root = list.get ( (begin + end) / 2 );
        root.left = balanceBST2 ( list, begin, (begin + end) / 2 - 1 );
        root.right = balanceBST2 ( list, (begin + end) / 2 + 1, end );

        return root;
    }

    //1038. 把二叉搜索树转换为累加树
    public TreeNode bstToGst(TreeNode root) {
        TreeNode root1 = root;
        Stack<TreeNode> stack = new Stack<> ();
        stack.push ( root );
        int count = 0;
        while (!stack.isEmpty ()) {
            root = stack.pop ();
            count += root.val;
            if (root.left != null) {
                stack.push ( root.left );
            }
            if (root.right != null) {
                stack.push ( root.right );
            }
        }
        root = root1;
        while (!stack.isEmpty () || root != null) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            int old = root.val;
            root.val = count;
            count -= old;
            root = root.right;
        }
        return root1;

    }

    //    剑指 Offer 32 - II. 从上到下打印二叉树 II
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> listAll = new ArrayList<> ();
        LinkedList<TreeNode> queue = new LinkedList<> ();
        if (root == null) {
            return listAll;
        }
        queue.offer ( root );
        while (!queue.isEmpty ()) {
            ArrayList<Integer> list = new ArrayList<> ();
            LinkedList<TreeNode> queue2 = new LinkedList<> ();
            while (!queue.isEmpty ()) {
                root = queue.poll ();
                list.add ( root.val );
                if (root.left != null) {
                    queue2.offer ( root.left );
                }
                if (root.right != null) {
                    queue2.offer ( root.right );
                }
            }
            queue = queue2;
            listAll.add ( list );
        }
        return listAll;
    }

    //剑指 Offer 54. 二叉搜索树的第k大节点
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<> ();
        ArrayList<Integer> list = new ArrayList<> ();
        while (!stack.isEmpty () || root != null) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            list.add ( root.val );

            root = root.right;
        }
        return list.get ( list.size () - k );

    }


    //    剑指 Offer 55 - II. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<> ();
        while (!stack.isEmpty () || root != null) {
            while (root != null) {
                stack.push ( root );
                root = root.left;
            }
            root = stack.pop ();
            Integer height1 = isBalanced2 ( root.left );
            Integer height2 = isBalanced2 ( root.right );
            if (Math.abs ( height1 - height2 ) > 1) {
                return false;
            }
            root = root.right;
        }
        return true;


    }

    //计算高度
    public Integer isBalanced2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max ( isBalanced2 ( root.left ), isBalanced2 ( root.right ) ) + 1;

    }

    //剑指 Offer 06. 从尾到头打印链表
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<> ();
        while (head != null) {
            stack.push ( head.val );
            head = head.next;
        }
        int[] arr = new int[stack.size ()];
        int i = 0;
        while (!stack.isEmpty ()) {
            arr[i] = stack.pop ();
            i++;
        }
        return arr;

    }

    public String reverseLeftWords(String s, int n) {
        return s.substring ( n, s.length () ) + s.substring ( 0, n );
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> list = new ArrayList<> ();
            for (int j = i; j < i + k; j++) {
                list.add ( nums[j] );
            }
            int max = getMax ( list );
            arr[i] = max;

        }
        return arr;

    }

    public int getMax(ArrayList<Integer> list) {
        int max = list.get ( 0 );
        for (Integer a : list
        ) {
            if (max < a) {
                max = a;
            }
        }
        return max;
    }

//760. 找出变位映射
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> hashMap = new HashMap<> ();
        for (int i = 0; i < B.length; i++) {
            hashMap.put ( B[i],i );
        }
        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            hashMap.put(A[i],i );
            arr[i] = hashMap.get (A[i] );
        }
        return arr;
    }

//1365. 有多少小于当前数字的数字
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] origin = new int[nums.length];
        int i = 0;
        for (int a : nums) {
            origin[i++] = a;
        }
        int length = nums.length;
        for (int m = 0; m < length; m++) {
            for (int n = m; n < (length-1); n++) {
                if (nums[n] > nums[n+1]){
                    nums[n] = nums[n] + nums[n+1];
                    nums[n+1] = nums[n] - nums[n+1];
                    nums[n] = nums[n] - nums[n+1];
                }
            }
        }
        HashMap<Integer, Integer> hashMap = new HashMap<> ();
        hashMap.put ( nums[0],0 );
        for (int k = 1; k < length; k++) {
           if (nums[k] == nums[k-1]){
               hashMap.put ( nums[k],k-1 );
           } else {
               hashMap.put ( nums[k],k );
           }
        }

        int[] arr = new int[length];
        i = 0;
        for (int a:origin
             ) {
            arr[i++] = hashMap.get ( a );
        }
        return arr;


    }


}



