package K15三数之和;


import java.util.*;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {

//        List<List<Integer>> lists = threeSum2 ( nums );
//        System.out.println (lists.size ());
    }



//   暴力法（超出时间限制）
//   static public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort ( nums );
//       ArrayList<List<Integer>> lists = new ArrayList<> ();
//       HashSet<Object> hashSet = new HashSet<> ();
//       int length = nums.length;
//       for (int i = 0; i < length-2; i++) {
//           for (int j = i+1; j < length-1; j++) {
//               for (int k = j+1; k < length; k++) {
//                   if (nums[i]+nums[j]+nums[k] == 0){
//                       ArrayList<Integer> list = new ArrayList<> ();
//                       list.add ( nums[i] );
//                       list.add ( nums[j] );
//                       list.add ( nums[k] );
//                       int hashCode = list.hashCode ();
//                       if (!hashSet.contains ( hashCode )){
//                           hashSet.add ( hashCode );
//                           lists.add ( list );
//                       }
//
//                   }
//               }
//           }
//       }
//       return lists;
//   }


//    双指针
//    static public List<List<Integer>> threeSum2(int[] nums) {
//        Arrays.sort ( nums );
//        ArrayList<List<Integer>> lists = new ArrayList<> ();
//        HashSet<Object> hashSet = new HashSet<> ();
//        int length = nums.length;
//        for (int i = 0; i < length-2; i++) {
//           int left = i+1;
//           int right = length -1;
//           int target = -nums[i];
//           while (left<right){
//               if (nums[left]+nums[right] == target){
//                   ArrayList<Integer> list = new ArrayList<> ();
//                   list.add ( nums[i] );
//                   list.add ( nums[left] );
//                   list.add ( nums[right] );
//                   lists.add ( list );
//                   while (left < right && nums[left] == nums[left++]);
//                   while (left < right && nums[right] == nums[right--]);
//               } else if(nums[left]+nums[right] < target){
//                   left++;
//               } else {
//                   right--;
//               }
//           }
//        }
//        return lists;
//    }

}