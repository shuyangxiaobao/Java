package 可以形成最大正方形的矩形数目1725;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public int countGoodRectangles(int[][] rectangles) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int[] arr:rectangles
        ) {
            int min = Math.min ( arr[0], arr[1] );
            if (min > max){
                result = 1;
                max = min;
            }else if(min == max){
                result++;
            }
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i]<prices[i+1]){
                result += (prices[i+1]-prices[i]);
            }
        }
        return result;
    }




    //    392. 判断子序列
    static public boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray ();
        char[] chars1 = t.toCharArray ();
        int index = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {

            for (int j = index; j < chars1.length; j++) {
                if (chars1[j] == chars[i]){
                    index = j;
                    index++;
                    result++;
                    break;
                }
            }
        }
        return result == chars.length;
    }

//    455. 分发饼干

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort ( g );
        Arrays.sort ( s );
        int result = 0;
        int index = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = index; j < s.length; j++) {
                if ( g[i] <= s[j] ){
                    result ++;
                    index ++;
                    break;
                }
                index ++;
            }
        }
        return result;
    }

    //605. 种花问题
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int result = 0;
        if (flowerbed.length >=2){
            if (flowerbed[0] == 0 && flowerbed[1] == 0){
                flowerbed[0] = 1;
                result++;
            }
        }
        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0 ){
                flowerbed[i]=1;
                result++;
                i++;
            }
        }
        int length = flowerbed.length;
        if (length >2){
            if (flowerbed[length-1]== 0 && flowerbed[length-2]== 0){
                result++;
            }
        }
        if (length == 1){
            if (flowerbed[length-1]== 0){
                result++;
            }
        }
        return result >= n;
    }



    //1716. 计算力扣银行的钱
    public int totalMoney(int n) {
        int sum = 0;
        int index = 0;
        int start = 0;
        for (int i = 1; i < n+1; i++) {
            if (i%7 == 1){
                start++;
                index = start;
                sum += index;
            } else {
                index++;
                sum += index;
            }
        }
        return sum;
    }


    //    53. 最大子序和
//    https://leetcode-cn.com/problems/maximum-subarray/
    static public int maxSubArray(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }

    static public int maxSubArray2(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum+=nums[j];
                max = Math.max ( max,sum );
            }
        }
        return max;
    }



    static public int maxSubArray3(int[] nums) {
        return   demo1 ( nums,0,nums.length-1 );
    }

    static public int demo1(int[] nums,int begin,int end) {

        if (end-begin == 1){
            int max = Math.max ( nums[begin], nums[end] );
            return Math.max (max , nums[begin]+nums[end] );

        }

        if (end-begin < 1){
            return nums[begin];
        }
        int mid = (begin + end) >> 1;

        int max = Integer.MIN_VALUE;

        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >=begin ; i--) {
            sum+=nums[i];
            leftMax = Math.max ( leftMax,sum );
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid+1; i<=end ; i++) {
            sum+=nums[i];
            rightMax = Math.max ( rightMax,sum );
        }
        max = Math.max ( leftMax+rightMax,max );

        int num1 = demo1 ( nums, begin, mid );
        max = Math.max ( num1,max );
        int num2 = demo1 ( nums, mid+1, end );
        max = Math.max ( num2,max );



        return max;
    }



    static public int majorityElement(int[] nums) {

        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < length; i++) {
            if (map.containsKey ( nums[i] )){
                map.put ( nums[i],map.get ( nums[i])+1  );
            } else {
                map.put ( nums[i],1 );
            }
        }
        Collection<Integer> values = map.values ();
        int max = Integer.MIN_VALUE;
        for (Integer value:values
        ) {
            max = Math.max ( max,value );
        }
        for (Integer key:map.keySet ()
        ) {
            if (map.get ( key ) == max){
                return key;
            }
        }
        return 0;
    }


    //    剑指 Offer 03. 数组中重复的数字
//    https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<> ();
        for (int a:nums
        ) {
            if (hashSet.contains ( a )){
                return a;
            }else {
                hashSet.add ( a );
            }
        }
        return 0;
    }

    //    剑指 Offer 11. 旋转数组的最小数字
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int a:numbers) {
            min = Math.min ( min,a );
        }
        return min;
    }


    static public int missingNumber(int[] nums) {
        int begin = 0;
        int end = nums.length-1;
        int mid = (begin+end) >> 1;
        while (true){
            if (nums[mid] == mid){
                begin = mid;
                mid = (begin+end) >> 1;
            } else{
                end = mid;
                mid = (begin+end) >> 1;
            }
            if (begin==mid){
                if (nums[begin] != begin){
                    return begin;
                }
                if (nums[end] != end){
                    return end;
                }
            }
            if (mid == nums.length -2){
                break;
            }
        }


//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i){
//                return i;
//            }
//        }
        return nums.length;
    }

    //    剑指 Offer 57. 和为s的两个数字
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int begin = 0;
        int end = length -1;
        int[] arr = new int[2];
        while (true){
            if (nums[begin] + nums[end] > target){
                end--;
            } else if(nums[begin] + nums[end] < target) {
                begin++;
            } else {
                arr[0] = nums[begin];
                arr[1] = nums[end];
                break;
            }
        }
        return arr;
    }

    //    剑指 Offer 59 - I. 滑动窗口的最大值
//    https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
    static public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;

        int[] resultArr = new int[length - k + 1];
        if (length == 0){
            return resultArr;
        }
        for (int i = 0; i <= length -k; i++) {
            int result = maxSlidingWindow_demo ( nums, k, i );
            resultArr[i] = result;
        }
        return resultArr;

    }

    static public int maxSlidingWindow_demo(int[] nums, int k,int begin) {
        int max = nums[begin];
        for (int i = begin; i < begin + k; i++) {
            max = Math.max ( max,nums[i] );
        }
        return max;
    }

    //    剑指 Offer 53 - I. 在排序数组中查找数字 I
    public int search(int[] nums, int target) {

        int result = 0;
        for (int a:nums
        ) {
            if (a == target){
                result++;
            } else{
                if (result > 1){
                    break;
                }
            }
        }
        return result;
    }


    //    LCP 18. 早餐组合
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort ( staple );
        Arrays.sort ( drinks );
        int result = 0;
        for (int s:staple) {
            for (int d:drinks) {
                if (s+d < x){
                    result++;
                }else {
                    break;
                }
            }
        }
        return result;
    }

    //    LCP 22. 黑白方格画
    static  public int paintingPlan(int n, int k) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i*n+j*n-i*j == k){
                    System.out.println (i);
                    System.out.println (j);
                    System.out.println ("=========");
                    int a = factorial(n)/(factorial ( i )*factorial ( n-i ));
                    int b = factorial(n)/(factorial ( j )*factorial ( n-j ));
                    result += a*b;
                }else if (i*n+j*n-i*j > k){
                    break;
                }
            }
        }
        return result;
    }


    static int factorial(int k){
        if (k == 0){
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result *= i;
        }
        return result;

    }


    public int maxProfit2(int[] prices) {
        int result = 0;
        int length = prices.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (prices[j]-prices[i]>max){
                    max = prices[j]-prices[i];
                }
            }
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
        int result = 0;
        int length = prices.length;
        int minPrice = prices[0];
        for (int i = 0; i < length; i++) {
            if (prices[i]<minPrice){
                minPrice = prices[i];
            } else {
                result = Math.max ( result, prices[i] - minPrice );
            }
        }
        return result;
    }


//322. 零钱兑换
//    https://leetcode-cn.com/problems/coin-change/

    static public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];

        int i = coinChange_sub ( coins, amount, dp );
        return i;

    }

    static public int coinChange_sub(int[] coins, int amount,int[] dp) {
        Arrays.sort ( coins );
        if (amount < 0){
            return -1;
        }
        for (int coin:coins) {
            if (coin < dp.length){
                dp[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin:coins) {
                if (coin <= i){
                    if (dp[i-coin] > 0){
                        min = Math.min (dp[i-coin]+1,min);
                    }
                    if (i-coin == 0){
                        min = Math.min (dp[i-coin]+1,min);
                    }
                } else {
                    break;
                }
            }
            if (min == Integer.MAX_VALUE){
                min = 0;
            }
            dp[i] = min;
        }
        if (dp[amount] > 0){
            return dp[amount];
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";
        if (text1.length () > text2.length ()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        lcs ( text1.toCharArray (),text2.toCharArray () );



    }

    static public int lcs(char[] nums1,char[] nums2){
        if(nums1 == null || nums1.length == 0) return 0;
        if(nums2 == null || nums2.length == 0) return 0;
        int[] dp = new int[nums1.length +1];
        for (int i = 1; i <= nums2.length; i++) {
            int cur = 0;
            for (int j = 1; j <= nums1.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (nums2[i-1] == nums1[j-1]){
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max ( dp[j],dp[j-1] );
                }
            }
        }
        return dp[nums1.length];
    }





}
