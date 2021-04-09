package K55跳跃游戏;


//
class Solution {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int last = length -1;
        for (int i = length-2; i >= 0; i--) {
            if ((nums[i] + i) >= last){
                last = i;
            }
        }
        return last == 0;
    }



}