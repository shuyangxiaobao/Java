package K239滑动窗口最大值;


import java.util.LinkedList;

//
class Solution2 {
    public static void main(String[] args) {

        Solution2 solution = new Solution2 ();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow (nums,3  );
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 1){
            return nums;
        }
        int length = nums.length;
        int[] result = new int[length - k + 1];
        LinkedList<Integer> queue = new LinkedList<> ();
        queue.addLast (0);
        for (int i = 1; i < length; i++) {
            while (!queue.isEmpty () && nums[queue.peekLast ()]<= nums[i]){
                queue.pollLast ();
            }
            queue.offerLast ( i );
            int begin = i - k + 1;
            if (begin >= 0){
                if (queue.peekFirst () < begin){
                    queue.pollFirst ();
                }
                result[begin] = nums[queue.peekFirst ()];
            }
        }
        return result;
    }




}