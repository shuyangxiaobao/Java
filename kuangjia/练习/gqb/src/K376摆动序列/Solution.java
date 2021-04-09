package K376摆动序列;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length < 3){
            return length;
        }

        int start = 0;
        int max = 1;
        boolean last = (nums[1]-nums[0] > 0);
        for (int i = 2; i < length; i++) {
            if ((nums[i] - nums[i-1] > 0) == !last){
                last = (nums[i]-nums[i-1] > 0);
                max = Math.max ( max,i-start+1 );
            } else {
                last = (nums[i]-nums[i-1] > 0);
                start = i-1;
                max = Math.max ( max,i-start+1 );
            }

        }
        return max;
    }




}