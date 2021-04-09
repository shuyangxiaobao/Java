package yiqian;

import com.sun.jdi.LongValue;

import java.util.*;

public class Main4 {

    class TwoSum {


        TreeMap<Integer, Integer> list;
        TreeMap<Integer, Integer> list2;
        Integer index;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            list = new TreeMap<> ();
            list2 = new TreeMap<> ();
            index = 0;

        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            list.put ( index, number );
            list2.put ( index, number );
            index++;

        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (int i = 0; i < index; i++) {
                Integer a = list.get ( i );
                list.remove ( i, a );
                if (list.containsValue ( value - a )) {
                    list.put ( i, a );
                    return true;
                } else {
                    list.put ( i, a );
                }
            }
            return false;
        }
    }

    //剑指 Offer 40. 最小的k个数
    static public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<> ( new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        } );

        int length = arr.length;
        for (int i = 0; i < k; i++) {
            queue.offer ( arr[i] );
        }

        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        for (int i = k; i < length; i++) {
            Integer peek = queue.peek ();
            System.out.println ();
            if (peek > arr[i]) {
                queue.poll ();
                queue.offer ( arr[i] );
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll ();
        }

        return result;
    }


    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<> ( new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //最大堆
            }
        } );

        int length = stones.length;
        for (int i = 0; i < length; i++) {
            queue.offer ( stones[i] );
        }
        while (queue.size () >= 2) {
            Integer x = queue.poll ();
            Integer y = queue.poll ();
            if (x == y) {

            } else {
                queue.offer ( x - y );
            }
        }
        if (queue.size () == 1) {
            return queue.poll ();
        }
        return 0;
    }


//
//    public static void yiqian.main(String[] args) {
//        int[] arr = new int[6];
//        arr[0] = 0;
//        arr[1] = 0;
//        arr[2] = 0;
//        arr[3] = 2;
//        arr[4] = 0;
//        arr[5] = 5;
//
//        getLeastNumbers ( arr, 0 );
//
//    }


    class KthLargest {
        PriorityQueue<Integer> queue;
        PriorityQueue<Integer> queue2;

        Integer index;

        public KthLargest(int k, int[] nums) {
            index = k;
            queue = new PriorityQueue<> ( new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1; //最大堆
                }
            } );
            queue2 = new PriorityQueue<> ( new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2; //最小堆
                }
            } );
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                queue.offer ( nums[i] );
            }

            for (int i = 0; i < k; i++) {
                if (!queue.isEmpty ()) {
                    queue2.offer ( queue.poll () );
                }
            }

        }

        public int add(int val) {
            queue.offer ( val );
//          if (queue2.isEmpty ()){
//              queue2.offer ( queue.poll () );
//              return val;
//          }
            if (queue2.size () == index) {
                if (queue2.peek () < queue.peek ()) {
                    queue2.poll ();
                    queue2.offer ( queue.poll () );
                }
            } else {
                queue2.offer ( queue.poll () );
            }
            return queue2.peek ();

        }
    }


    //215. 数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<> ( new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        } );
        for (int i = 0; i < k; i++) {
            queue.offer ( nums[i] );
        }
        int length = nums.length;
        for (int i = k; i < length; i++) {
            if (queue.peek () < nums[i]) {
                queue.poll ();
                queue.offer ( nums[i] );
            }
        }
        return queue.peek ();
    }


    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<> ( new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        } );
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            queue.offer ( arr[i] );
        }
        int length = arr.length;
        if (k == 0) {
            return result;
        }
        for (int i = k; i < length; i++) {
            if (queue.peek () > arr[i]) {
                queue.poll ();
                queue.offer ( arr[i] );
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll ();
        }
        return result;
    }


    //最接近原点的 K 个点
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> queue = new PriorityQueue<int[]> ( new Comparator<int[]> () {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a1 = o1[0] * o1[0] + o1[1] * o1[1];
                int a2 = o2[0] * o2[0] + o2[1] * o2[1];
                return a2 - a1;
            }
        } );
        for (int i = 0; i < K; i++) {
            queue.offer ( points[i] );
        }
        int length = points.length;
        for (int i = 0; i < length; i++) {
            int[] point = points[i];
            int[] peek = queue.peek ();
            int b = peek[0] * peek[0] + peek[1] * peek[1];
            int b1 = point[0] * point[0] + point[1] * point[1];
            if (b1 < b) {
                queue.poll ();
                queue.offer ( point );
            }
        }

        int[][] arr = new int[K + 1][2];
        int j = 0;
        for (int i = 0; i < length; i++) {
            arr[j++] = queue.poll ();
        }
        return arr;
    }


    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        HashMap<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey ( arr1[i] )) {
                map.put ( arr1[i], map.get ( arr1[i] ) + 1 );
            } else {
                map.put ( arr1[i], 1 );
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey ( arr2[i] )) {
                map.put ( arr2[i], map.get ( arr2[i] ) + 1 );
            } else {
                map.put ( arr2[i], 1 );
            }
        }

        for (int i = 0; i < arr3.length; i++) {
            if (map.containsKey ( arr3[i] )) {
                map.put ( arr3[i], map.get ( arr3[i] ) + 1 );
            } else {
                map.put ( arr3[i], 1 );
            }
        }
        ArrayList<Integer> list = new ArrayList<> ();
        PriorityQueue<Integer> queue = new PriorityQueue<> ( new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        } );
        Set<Map.Entry<Integer, Integer>> set = map.entrySet ();
        for (Map.Entry<Integer, Integer> obj : set
        ) {
            if (obj.getValue () == 3) {
                queue.add ( obj.getKey () );
            }
        }

        while (!queue.isEmpty ()) {
            list.add ( queue.poll () );
        }
        return list;
    }


    //面试题 17.09. 第 k 个数
    static public long getKthMagicNumber(int k) {
        ArrayList<Long> list = new ArrayList<> ();
        list.add ( 1l );
        list.add ( 3l );
        list.add ( 5l );
        list.add ( 7l );
        list.add ( 9l );

        PriorityQueue<Long> queue = new PriorityQueue<> ( new Comparator<Long> () {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o1 - o2);
            }
        } );

        for (int i = 5; i <= k; i++) {
            queue.clear ();
            Long last = list.get ( list.size () - 1 );
            for (int j = 0; j < list.size () - 1; j++) {
                if (list.get ( j ) * 3 >= Long.MAX_VALUE) {
                    break;
                }
                if (list.get ( j ) * 3 > last) {
                    queue.add ( list.get ( j ) * 3 );
                }
                if (list.get ( j ) * 5 > last) {
                    queue.add ( list.get ( j ) * 5 );
                }
                if (list.get ( j ) * 7 > last) {
                    queue.add ( list.get ( j ) * 7 );
                }
            }

            list.add ( queue.peek () );
        }
        return list.get ( k - 1 );

    }


    public double average(int[] salary) {

        int length = salary.length;
        int max = salary[0];
        int min = salary[0];
        int sum = 0;
        for (int a : salary) {
            sum += a;
            if (min > a) {
                min = a;
            }
            if (max < a) {
                max = a;
            }
        }
        return (sum - min - max) / (length - 2);
    }


    //1528. 重新排列字符串
    public String restoreString(String s, int[] indices) {
        int length = s.length ();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[indices[i]] = s.charAt ( i );
        }
        return new String ( chars );
    }

    // 867. 转置矩阵
    public int[][] transpose(int[][] A) {
        int a = A.length;
        int b = A[0].length;
        int[][] B = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                B[i][j] = A[j][i];
            }
        }
        return B;
    }

    //    面试题 17.10. 主要元素
    static public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<> ();
        int length = nums.length;
        for (int a : nums
        ) {
            if (!map.containsKey ( a )) {
                map.put ( a, 1 );
            } else {
                Integer value = map.get ( a );
                map.put ( a, ++value );
                if (value << 1 > length) {
                    return a;
                }
            }
        }
        return -1;
    }


    // 88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (index1 < m && nums1[index1] < nums2[index2]) {
                arr[i] = nums1[index1++];
            } else {
                arr[i] = nums2[index2++];
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }


    //    合并两个有序链表
    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = new ListNode ( 0 );
        ListNode result = root;
        while (l2 != null && l1 != null) {
            if (l1.val < l2.val) {
                root.next = l1;
                l1 = l1.next;
                root = root.next;
            } else {
                root.next = l2;
                l2 = l2.next;
                root = root.next;
            }
        }
        if (l2 == null && l1 != null) {
            root.next = l1;
        }
        if (l1 == null && l2 != null) {
            root.next = l2;
        }
        return result.next;
    }

    static public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        ListNode listNode = mergeKLists_index ( lists, 0, length );
        return listNode;
    }

    static public ListNode mergeKLists_index(ListNode[] lists, int begin, int end) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (end - begin < 2) {

            return lists[begin];
        }
        int middle = (begin + end) >> 1;
        ListNode left = mergeKLists_index ( lists, begin, middle );
        ListNode right = mergeKLists_index ( lists, middle, end );
        return mergeTwoLists ( left, right );
    }


    //7. 整数反转
    public int reverse(int x) {
        int a = 1;
        int result = 0;
        while (x != 0) {
            int i = x % 10;
            result = 10 * result + i;
            x = x / 10;
        }
        return result;
    }

    //344. 反转字符串
    public void reverseString(char[] s) {
        int length = s.length;
        int middle = length >> 1;
        char temp;
        for (int i = 0; i < middle; i++) {
            temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }


    //9. 回文数
    public boolean isPalindrome(int x) {
        ArrayList<Integer> list = new ArrayList<> ();
        if (x < 0) {
            return false;
        }
        while (x > 0) {
            list.add ( x % 10 );
            x = x / 10;
        }
        int size = list.size ();

        for (int i = 0; i < (size >> 1); i++) {
            if (!list.get ( i ).equals ( list.get ( size - i - 1 ) )) {
                return false;
            }
        }
        return true;
    }


    //26. 删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {

        int a = nums[0] - 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != a) {
                count++;
                a = nums[i];
            }
        }
        return count;
    }


    //129. 求根到叶子节点数字之和
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int end = 0;
        if (root.left != null) {
            end = 10 * root.val + sumNumbers ( root.left );
        }
        if (root.right != null) {
            end += 10 * root.val + sumNumbers ( root.right );
        }
        return end;
    }


    //463. 岛屿的周长
    public int islandPerimeter(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int a1, a2, b1, b2;
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                a1 = i - 1;
                a2 = i + 1;
                b1 = j - 1;
                b2 = j + 1;
                if (a1 < 0 || grid[a1][j] == 0) {
                    count++;
                }
                if (b1 < 0 || grid[i][b1] == 0) {
                    count++;
                }
                if (a2 >= a || grid[a2][j] == 0) {
                    count++;
                }
                if (b2 >= b || grid[i][b2] == 0) {
                    count++;
                }

            }
        }
        return count;
    }


    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }


    //    面试题 02.03. 删除中间节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //349. 两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<> ();
        HashSet<Integer> hashSet2 = new HashSet<> ();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add ( nums1[i] );
        }
        for (int j = 0; j < nums2.length; j++) {
            if (hashSet.contains ( nums2[j] )) {
                hashSet2.add ( nums2[j] );
            }
        }
        int k = 0;
        int[] arr = new int[hashSet2.size ()];
        int size = hashSet2.size ();
        Iterator<Integer> iterator = hashSet2.iterator ();
        while (iterator.hasNext ()) {
            arr[k++] = iterator.next ();
        }
        return arr;
    }


    //    1086. 前五科的均分
    public int[][] highFive(int[][] items) {
//        先排序，id相同，分数从大到小；id不同，id从小到大
        Arrays.sort ( items, ((a, b) -> (
                (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]
        )) );
        int number = items[items.length - 1][0];
        int[][] arr = new int[number][2];
        int k = 1;
        for (int i = 0; i < items.length; i++) {
            int[] item = items[i];
            if (item[0] != k) {
                continue;
            }
            int zong = 0;
            for (int j = 0; j < 5; j++) {
                zong += items[j + i][1];
            }
            arr[k - 1][0] = k;
            arr[k - 1][1] = zong / 5;
            k++;
            i += 4;
        }
        return arr;
    }


    static public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int index1 = -1;
        int index2 = -1;
        int temp = 0;
        int i = 0;
        int j = 0;
        while (i < length || j < length) {

            while (i < length) {
                if ((A[i] + i) % 2 != 0 && i % 2 == 0) {
                    index1 = i;
                    i++;
                    break;
                }
                i++;
            }
            while (j < length) {
                if ((A[j] + j) % 2 != 0 && j % 2 == 1) {
                    index2 = j;
                    j++;
                    break;
                }
                j++;
            }
            if (index1 >= 0 && index2 >= 0) {
                A[index1] = A[index1] + A[index2];
                A[index2] = A[index1] - A[index2];
                A[index1] = A[index1] - A[index2];
                index2 = -1;
                index1 = -1;
            }
        }
        return A;
    }

    //1502. 判断能否形成等差数列
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort ( arr );
        if (arr.length < 3) {
            return true;
        }
        int k = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != k) {
                return false;
            }
        }
        return true;
    }


    //    128. 最长连续序列
    static public int longestConsecutive(int[] nums) {
        Arrays.sort ( nums );
        if (nums.length < 2) {
            return nums.length;
        }
        int k = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                k++;
            } else if (nums[i] - nums[i - 1] == 0) {
                continue;
            } else {
                if (k > max) {
                    max = k;
                }
                k = 1;
            }


        }
        if (k > max) {
            max = k;
        }
        return max;
    }


//62. 不同路径
    public int uniquePaths(int m, int n) {

        int a = m+n-2;
        int b = n-1;
        int count = 1;
        int count2 = 1;
        for (int i = 1; i <= b; i++) {
            count = count *i;
        }
        for (int i = 0; i < b; i++) {
            count2 = count2 *(m+n-2-i);
        }
        return count2/count;

    }


//57. 插入区间
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] intervals1 = intervals;
        int a = newInterval[0];
        int b = newInterval[1];
        int length = intervals.length;
        int index1 = 0;
        int index2 = 0;
        boolean middle1 = false;
        boolean middle2 = false;
        for (int i = 0; i < length; i++) {
            int[] arr = intervals[i];
            if (arr[0] > a){
                index1 = i;
                break;
            }
            if (arr[1] > a){
                index1 = i;
                middle1 = true;
                break;
            }
        }

        for (int i = 0; i < length; i++) {
            int[] arr = intervals[i];
            if (arr[0] > b){
                index1 = i;
                break;
            }
            if (arr[1] > b){
                index1 = i;
                middle2 = true;
                break;
            }
        }

        int start = 0;
        int end = 0;
        if (middle1){
            int[] arr = intervals[index1];
            start = arr[0];
        } else {
            start = a;
        }

        if (middle2){
            int[] arr = intervals[index2];
            end = arr[1];
        } else {
            end = b;
        }

        int size = 0;
        if (middle2){
            size = length - (index2 - index1);
            int[][] result = new int[size][2];
            for (int i = 0; i < size; i++) {
                if (i < index1){
                    result[i] =  intervals[i];
                } else if(i == index1){
                    result[i][0] = start;
                    result[i][1] = end;
                } else {
                    result[i] =  intervals[i+(index2 - index1)];
                }
            }
            return result;
        }else {
            size = length - (index2 - index1 - 1);
            int[][] result = new int[size][2];
            for (int i = 0; i < size; i++) {
                if (i < index1){
                    result[i] =  intervals[i];
                } else if(i == index1){
                    result[i][0] = start;
                    result[i][1] = end;
                } else {
                    result[i] =  intervals[i+(index2 - index1-1)];
                }
            }
            return result;

        }
    }

//14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0){
            return "";
        }
        String result = strs[0];

        for (int i = 1; i < length; i++) {
            result =  longestCommonPrefix2(result,strs[i]);
        }
        return result;

    }

    public String longestCommonPrefix2(String str1,String str2) {

        char[] chars1 = str1.toCharArray ();
        char[] chars2 = str2.toCharArray ();
        int min = Math.min ( chars1.length,chars2.length );
        String string = "";
        for (int i = 0; i < min; i++) {
            if (Objects.equals ( chars1[i],chars2[i] )){
                string = string+chars1[i];
            } else {
                return string;
            }
        }
        return string;
    }



    public int hammingWeight(int n) {
        int a = 1;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & a) != 0){
                result++;
            }
            a = a << 1;
        }
        return result;
    }

//    136. 只出现一次的数字
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<> ();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (hashSet.contains ( nums[i] )){
                hashSet.remove ( nums[i] );
            }else {
                hashSet.add ( nums[i] );
            }
        }
        return hashSet.iterator ().next ();
    }

//171. Excel表列序号
   static public int titleToNumber(String s) {
       int length = s.length ();
       int value = 0;
       for (int i = 0; i < length; i++) {
           int num = s.charAt ( i ) - 'A' + 1;
           value = value*26+num;
       }
       return value;
   }

//    剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (root.val < p.val && root.val < q.val){
                root = root.left;
            }else if((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val)){
                break;
            } else {
                root = root.right;
            }
        }
        return root;
    }

//111. 二叉树的最小深度
//   递归版本
//public int minDepth(TreeNode root) {
//    if (root == null) {
//        return 0;
//    }
//    if (root.left == null) {
//        return minDepth ( root.right ) + 1;
//    }
//    if (root.right == null) {
//        return minDepth ( root.left ) + 1;
//    }
//    return Math.min ( minDepth ( root.left ), minDepth ( root.right ) ) + 1;
//}

//迭代版本

    class QueueNode{
        TreeNode node;
        int depth;
        TreeNode parent;

        public QueueNode(TreeNode node, int depth, TreeNode parent) {
            this.node = node;
            this.depth = depth;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        LinkedList<QueueNode> queue = new LinkedList<> ();
        QueueNode queueNode = new QueueNode ( root, 1,null);
        queue.offer ( queueNode );

        QueueNode x_node = null;
        QueueNode y_node = null;

        while (!queue.isEmpty ()){
            QueueNode node = queue.poll ();
            if (node.node.val == x){
                x_node = node;
            }
            if (node.node.val == y){
                y_node = node;
            }
            if (node.node.left != null){
                QueueNode leftNode = new QueueNode ( node.node.left, node.depth +1 ,node.node);
                queue.offer ( leftNode );
            }
            if (node.node.right != null){
                QueueNode rightNode = new QueueNode ( node.node.right, node.depth + 1,node.node );
                queue.offer ( rightNode );            }
        }
        if ((x_node.depth == y_node.depth) &&((x_node.parent.val != y_node.parent.val))){
            return true;
        }
        return false;
    }




    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<> ();
        if (root == null){
            return null;
        }
        list.add ( root.val );
        if (root.left == null && root.right == null){
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<> ();
        queue.offer ( root );
        while (!queue.isEmpty ()){
            LinkedList<TreeNode> queue2 = new LinkedList<> ();
            List<Integer> listetemp = new ArrayList<> ();

            while (!queue.isEmpty ()){
                TreeNode node = queue.poll ();
                if (node.left != null){
                    queue2.offer ( node.left );
                    listetemp.add ( node.left.val );
                }
                if (node.right != null){
                    queue2.offer ( node.right );
                    listetemp.add ( node.right.val );
                }
            }
            if (listetemp.size () > 1){
                list.add ( listetemp.get ( listetemp.size () - 1 ) );
            }
            queue = queue2;
        }
        return list;
    }




//    191. 位1的个数
    public static void main(String[] args) {

        titleToNumber("32");
//        int[] nums = {1, 2, 0, 1};
//        longestConsecutive ( nums );
    }


}
