package K84柱状图中最大的矩形;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max ( max, largestRectangleArea(heights,i));
        }
        return max;
    }



    public int largestRectangleArea(int[] heights,int index) {
        int length = heights.length;
        int left = index -1;
        int right = index + 1;
        while (left >= 0){
            if (heights[index] <= heights[left]){
                left--;
            } else {
             break;
            }
        }
        while (right < length){
            if (heights[index] <= heights[right]){
                right++;
            } else {
                break;
            }
        }
        return (right-left-1)*heights[index];
    }



}