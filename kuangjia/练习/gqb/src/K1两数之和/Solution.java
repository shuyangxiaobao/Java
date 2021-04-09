package K1两数之和;


import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.*;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] sum = twoSum ( nums, 9 );
        System.out.println (sum);





    }


    static public int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        int length = nums.length;
        ArrayList<Integer> list = new ArrayList<> ();
        for (int i = 0; i < length; i++) {
            list.add ( nums[i] );
        }
        Arrays.sort ( nums );
        int left = 0;
        int right = length-1;
        while (left<right){
            int sum = nums[left] + nums[right];
            if (sum < target){
                left++;
            } else if(sum > target){
                right--;
            } else {
                if (nums[left] == nums[right]){
                    arr[0]=list.indexOf ( nums[left] );
                    list.remove ( arr[0] );
                    arr[1]=list.indexOf ( nums[right] )+1;

                } else {
                    arr[0]=list.indexOf ( nums[left] );
                    arr[1]=list.indexOf ( nums[right] );
                }
                break;
            }
        }
        return arr;
    }

  static public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int length = numbers.length;
        int left = 0;
        int right = length-1;
        while (left<right){
            int sum = numbers[left] + numbers[right];
            if (sum < target){
                left++;
            } else if(sum > target){
                right--;
            } else {
                arr[0] = left+1;
                arr[1] = right+1;
                break;
            }
        }
        return arr;
    }

    class TwoSum {

        List<Integer>list;
        /** Initialize your data structure here. */
        public TwoSum() {
            list = new ArrayList<> (  );
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            list.add ( number );
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            int left = 0;
            int right = list.size () -1;
            list.sort ( new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            } );
            while (left <right){
                int sum = list.get ( left )+list.get ( right );
                if (sum < value){
                    left++;
                } else if(sum > value){
                    right--;
                } else {
                    return true;
                }

            }
            return false;
        }
    }

}