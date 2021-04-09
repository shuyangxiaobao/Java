package K18四数之和;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://leetcode-cn.com/problems/perfect-squares/


class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {


    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort ( nums );
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        HashSet<List<Integer>> hashSet = new HashSet<> ();
        int length = nums.length;
        for (int i = 0; i < length-3; i++) {
            for (int j = i+1; j < length-2; j++) {
                int sum = target-nums[i]-nums[j];
                int left = j+1;
                int right = length-1;
                while (left < right){
                    int count = nums[left] + nums[right];
                    if (count < sum){
                        left++;
                    } else if(count > sum){
                        right--;
                    }else {
                        ArrayList<Integer> list = new ArrayList<> ();
                        list.add ( nums[i] );
                        list.add ( nums[j] );
                        list.add ( nums[left] );
                        list.add ( nums[right] );
                        if (!hashSet.contains ( list )){
                            hashSet.add ( list );
                            lists.add ( list );
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return lists;
    }





}
