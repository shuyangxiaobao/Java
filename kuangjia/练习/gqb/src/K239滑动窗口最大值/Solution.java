package K239滑动窗口最大值;


import java.util.LinkedList;

//
class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution ();
        int[] nums = {1,3,1,2,0,5};
//        solution.maxSlidingWindow (nums,3  );
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int length = nums.length;
//        int[] dp = new int[length - k + 1];
//        int max0 = nums[0];
//        for (int i = 0; i < k; i++) {
//            max0 = Math.max ( max0,nums[i] );
//        }
//        dp[0] = max0;
//        for (int i = k; i < length; i++) {
//            if (nums[i-k] < dp[i-k] || nums[i] >= dp[i-k]){
//                dp[i-k+1] = Math.max ( dp[i-k],nums[i]);
//            } else{
//                dp[i-k+1] = maxSlidingWindow_sub(nums,k,i);
//            }
//        }
//        return dp;
//    }
//
//
//    public int maxSlidingWindow_sub(int[] nums, int k,int endIndex) {
//        int max = Integer.MIN_VALUE;
//        for (int i = endIndex; k > 0 ; i--) {
//            max =  Math.max (nums[i],max);
//            k--;
//        }
//        return max;
//    }



//        public int[] maxSlidingWindow(int[] nums, int k) {
//            if (nums == null || nums.length == 0 || k < 1){
//                return null;
//            }
//            if (k == 1){
//                return nums;
//            }
//            int[] maxes = new int[nums.length - k + 1];
//            LinkedList<Integer> deque = new LinkedList<> ();
//            for (int i = 0; i < nums.length; i++) {
//                while (!deque.isEmpty () && nums[i] >= nums[deque.peekLast ()]){
//                    deque.pollLast ();
//                }
////                将i加到队尾
//                deque.offerLast ( i );
////                检查窗口的索引是否合法
//                int w = i-k+1;
//                if (w< 0){
//                    continue;
//                }
////               检查队头的合法性
//                if (deque.peekFirst () < w){
//                    deque.pollFirst ();
//                }
//                maxes[w] = nums[deque.peekFirst ()];
//            }
//            return maxes;
//        }






}