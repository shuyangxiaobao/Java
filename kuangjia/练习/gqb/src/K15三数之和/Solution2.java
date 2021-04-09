package K15三数之和;


import java.lang.reflect.Array;
import java.util.*;

//https://leetcode-cn.com/problems/perfect-squares/
class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2 ();
        int[] nums = {0,0,0,0};
        List<List<Integer>> lists = solution2.threeSum ( nums );
        System.out.println (lists.size ());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort ( nums );
        int length = nums.length;
        ArrayList<List<Integer>> lists = new ArrayList<> ();
        HashSet<List<Integer>> hashSet = new HashSet<> ();

        for (int i = 1; i < length-1; i++) {
            int start = 0;
            int end = length-1;
            int target = -nums[i];
            while (start < end && start < i && end > i){
                int sum = nums[start] + nums[end];
                if (sum > target){
                    end--;
                } else if(sum < target){
                    int oldStart = start;
                    start++;
                    while ( start < length&& nums[start] == nums[oldStart] ){
                        start++;
                    }
                } else {
                    ArrayList<Integer> list = new ArrayList<> ();
                    list.add ( nums[start] );
                    list.add ( nums[i] );
                    list.add ( nums[end] );
//                    if (!hashSet.contains ( list )){
//                        hashSet.add ( list );
//                        lists.add ( list );
//                    }
                    lists.add ( list );
                    int oldStart = start;
                    start++;
                    while (start < length && nums[start] == nums[oldStart] ){
                        start++;
                    }

                    int oldEnd = end;
                    end--;
                    while (end >= 0 && nums[end] == nums[oldEnd] ){
                        end--;
                    }
                }
            }

        }
        return lists;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> all_list = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(n < 3)
            return all_list;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int t = -nums[i];
            if(t < 0)   break;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] > t) {
                    k--;
                } else if (nums[j] + nums[k] < t) {
                    j++;
                } else {
                    // find
                    List<Integer> ans = new LinkedList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    all_list.add(ans);
                    // 去除临近相同的元素
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return all_list;

    }


}