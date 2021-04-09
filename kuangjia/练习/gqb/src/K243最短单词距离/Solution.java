package K243最短单词距离;


//https://leetcode-cn.com/problems/perfect-squares/
class Solution {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        shortestDistance ( words,"coding","practice" );

    }

   static public int shortestDistance(String[] words, String word1, String word2) {
        int length = words.length;
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {

            if (word1.equals ( words[i] )){
                index1 = i;
            }
            if (word2.equals ( words[i] )){
                index2 = i;
            }
            if (index1 >=0 && index2 >=0){
                min = Math.min ( min,Math.abs ( index1-index2 ) );
            }
        }
       System.out.println (min);
        return min;
    }




}