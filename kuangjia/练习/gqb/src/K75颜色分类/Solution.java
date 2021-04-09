package K75颜色分类;


//
class Solution {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors ( nums );

    }


    static public void sortColors(int[] nums) {
        int length = nums.length;
        int begin = 0;
        int end = length-1;
        for (int i = 0; i <= end;) {
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[begin];
                nums[begin++] = temp;
                i++;
            } else if (nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end--] = temp;

            }else if (nums[i] == 1){
               i++;
            }
        }
        System.out.println (nums);
    }



}