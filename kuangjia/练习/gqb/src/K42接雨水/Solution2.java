package K42接雨水;


class Solution2 {


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2 ();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        solution2.trap ( height );
    }

    public int trap(int[] height) {
        int length = height.length;
        if (length < 3){
           return 0;
        }
        int[] rightArr = new int[length];
        rightArr[0] = height[0];
        for (int i = 1; i < length; i++) {
            rightArr[i] = Math.max ( rightArr[i-1], height[i]);
        }

        int[] leftArr = new int[length];
        leftArr[length-1] = height[length-1];
        for (int i = length-2; i >= 0; i--) {
            leftArr[i] = Math.max ( leftArr[i+1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int min = Math.min ( leftArr[i],rightArr[i] );
            sum += (min-height[i]);
        }
        System.out.println (sum);
        return sum;
    }


}