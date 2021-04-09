package K905按奇偶排序数组;


//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {


    }
    public int[] sortArrayByParity2(int[] A) {
        int[] arr = new int[A.length];
        int left = 0;
        int right = A.length -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 == 0){
                arr[left] = A[i];
                left++;
            }else {
                arr[right] = A[i];
                right--;
            }
        }
        return arr;
    }

    public int[] sortArrayByParity(int[] A) {
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j++;
            }
        }
        return A;
    }


}