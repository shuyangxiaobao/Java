package K455分发饼干;


import java.util.Arrays;

//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
//        solution.

    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort ( g );
        Arrays.sort ( s );
        int glength = g.length;
        int slength = s.length;
        int g_start = 0;
        int s_start = 0;
        int count = 0;
        while (g_start < glength && s_start < slength){
            if (s[s_start] >= g[g_start]){
                count++;
                s_start++;
                g_start++;
            } else {
                s_start++;
            }
        }
        return count;
    }




}