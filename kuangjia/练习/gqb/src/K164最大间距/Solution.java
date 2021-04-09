package K164最大间距;


import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {

        "234567".charAt ( 1 );
        String[] arr = new String[]{"11","22","33"};
        arr[0] = "90";
        System.out.println (arr);


    }


    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length < 2){
            return 0;
        }
        Arrays.sort ( nums );
        int max = 0;
        for (int i = 1; i < length; i++) {
            max = Math.max ( max,nums[i]-nums[i-1]);
        }
        return max;



    }




}