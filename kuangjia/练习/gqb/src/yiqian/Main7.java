package yiqian;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main7 {

    public static void main(String[] args) {

//        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] ints = dailyTemperatures ( arr );
//        for (int a:ints
//             ) {
//            System.out.println (a);
//        }
    }


    static public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] arr = new int[T.length];
        for (int i = 0; i < length; i++) {
            arr[i] = demo1 ( T, i );
        }
        return arr;

    }

    static public int demo1(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                return i - index;
            }
        }
        return 0;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<> ();
        queue.offer ( root );
        int a = 0;
        while (!queue.isEmpty ()) {
            LinkedList<TreeNode> queue2 = new LinkedList<> ();
            a++;
            while (!queue.isEmpty ()) {
                TreeNode node = queue.pop ();
                if (node.left != null) {
                    queue2.offer ( node.left );
                }
                if (node.right != null) {
                    queue2.offer ( node.right );
                }
            }
            queue = queue2;
        }
        return a;
    }


    //    剑指 Offer 17. 打印从1到最大的n位数
    public int[] printNumbers(int n) {
        int a = 0;
        for (int i = 0; i < n; i++) {
            a *= 10;
        }
        a--;
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = i;
        }
        return arr;
    }

    //    剑指 Offer 15. 二进制中1的个数
    public int hammingWeight(int n) {
        int index = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                index++;
            }
            n = (n >> 1);
        }
        return index;
    }


////    剑指 Offer 68 - II. 二叉树的最近公共祖先
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//    }



}
