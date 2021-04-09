package K0算法面试题汇总.N2多数元素;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int singleNumber(int[] nums) {
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = nums[i] ^ result;
        }
        return result;
    }




}