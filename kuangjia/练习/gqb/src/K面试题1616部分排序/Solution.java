package K面试题1616部分排序;


import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {

        int[] array = {1,5,4,3,2,6,7,2,8};
        subSort2(array);
    }


    static public int[] subSort1(int[] array) {
        int length = array.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = array[i];
        }
        Arrays.sort ( arr );
        int begin = 0;
        if(length < 2){
            int[] result = new int[2];
            result[0] =-1;
            result[1] =-1;
            return result;
        }
        while (begin<length && arr[begin] == array[begin]){
            begin++;
        }
        if(begin == length){
            begin = -1;
        }
        int end = length-1;
        while (end>=0 && arr[end] == array[end]){
            end--;
        }
        int[] result = new int[2];
        result[0] =begin;
        result[1] =end;
        return result;
    }


    static public int[] subSort2(int[] array) {
        int begin = -1;
        int end = -1;
        int length = array.length;
        if(length < 2){
            int[] result = new int[2];
            result[0] =-1;
            result[1] =-1;
            return result;
        }
        int max = array[0];
        for (int i = 1; i < length; i++) {
            max = Math.max ( max,array[i] );
            if (array[i] < max){
                begin = i;
            }
        }
        if (begin != -1){
            int min = array[length-1];
            for (int i = length-1; i >= 0; i--) {
                min = Math.min ( min,array[i] );
                if (array[i] > min){
                    end = i;
                }
            }
        }
        int[] result = new int[2];
        result[0] =end;
        result[1] =begin;
        return result;
    }


    static public int[] subSort(int[] array) {
        int begin = -1;
        int end = -1;
        int length = array.length;
        if(length < 2){
            int[] result = new int[2];
            result[0] =-1;
            result[1] =-1;
            return result;
        }
        int max = array[0];
        int min = array[length-1];

        int j = 0;
        for (int i = 1; i < length; i++) {
            max = Math.max ( max,array[i] );
            if (array[i] < max){
                begin = i;
            }
            j = length-i;
            min = Math.min ( min,array[j] );
            if (array[j] > min){
                end = j;
            }
        }
        j = 0;
        min = Math.min ( min,array[j] );
        if (array[j] > min){
            end = j;
        }
        int[] result = new int[2];
        result[0] =end;
        result[1] =begin;
        return result;
    }




}