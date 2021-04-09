package K560和为K的子数组;


import java.util.HashMap;

//
class Solution {
    public static void main(String[] args) {

    }


    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            if (sum == k){
                count++;
            }
            for (int j = i+1; j < length; j++) {
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }


    public int subarraySum2(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<> ();
        hashMap.put ( 0,1 );
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (hashMap.containsKey ( sum-k )){
                count += hashMap.get ( sum-k );
            }
            hashMap.put ( sum,hashMap.getOrDefault ( sum,0 )+1 );
        }
        return count;
    }




}