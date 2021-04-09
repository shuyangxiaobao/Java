package yiqian;

import java.util.ArrayList;
import java.util.List;

public class Main5 {


//    463. 岛屿的周长 start
    public int islandPerimeter(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 1)
              return   demo1 ( grid,i,j );
            }
        }
        return 0;
    }


    public int demo1(int[][] grid,int a,int b){

        if (!safeArea ( grid,a,b )){
            return 1;
        }

        if (grid[a][b] == 0){
            return 1;
        }
        grid[a][b] = 2;
        return demo1( grid,a,b-1 ) + demo1( grid,a,b+1 ) + demo1( grid,a-1,b ) + demo1( grid,a+1,b );

    }
    public boolean safeArea(int[][] grid,int a,int b){
        int aLength = grid.length;
        int bLength = grid[0].length;
        return a >=0 && a < aLength && b >= 0 && b <  bLength;
    }

//463. 岛屿的周长 end


//    695. 岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int max = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 1) {
                    int num = demo2 ( grid, i, j );
                    if (num > max) {
                        max = num;
                    }
                }
            }
        }
        return max;
    }


    public int demo2(int[][] grid,int a,int b){

        if (!safeArea ( grid,a,b )){
            return 0;
        }

        if (grid[a][b] == 0){
            return 0;
        }
        if (grid[a][b] == 2){
            return 0;
        }
        if (grid[a][b] == 1){
            grid[a][b] = 2;
            return 1+ demo2( grid,a,b-1 ) + demo2( grid,a,b+1 ) + demo2( grid,a-1,b ) + demo2( grid,a+1,b );
        }
        return 0;


    }


//200. 岛屿数量
    public int numIslands(char[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int max = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == '1') {
                    demo3 ( grid, i, j );
                    max++;
                }
            }
        }
        return max;
    }


    public void demo3(char[][] grid,int a,int b){

        if (!safeArea2 ( grid,a,b )){
            return ;
        }

        if (grid[a][b] == '0'){
            return ;
        }
        if (grid[a][b] == '1'){
            grid[a][b] = '0';
            demo3 ( grid,a-1 ,b);
            demo3 ( grid,a+1 ,b);
            demo3 ( grid,a ,b-1);
            demo3 ( grid,a ,b+1);


        }
    }

    public boolean safeArea2(char[][] grid,int a,int b){
        int aLength = grid.length;
        int bLength = grid[0].length;
        return a >=0 && a < aLength && b >= 0 && b <  bLength;
    }

//257. 二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<> ();

        if (root == null){
            return list;
        }
        list.add ( root.val + "" );
        List<String> leftList = new ArrayList<> ();;
        List<String> rightList = new ArrayList<> ();;

        if (root.left != null){
            leftList = binaryTreePaths ( root.left );
        }
        if (root.right != null){
            rightList = binaryTreePaths ( root.right );
        }
        if ( leftList.size () > 0){
            for (String title:leftList
            ) {
                title = root.val + "->"+title;
                list.add ( title );
            }
        }
        if (rightList.size () > 0){
            for (String title:rightList
            ) {
                title = root.val + "->"+title;
                list.add ( title );
            }
        }
        return list;
    }

////112. 路径总和
//    public boolean hasPathSum(TreeNode root, int sum) {
//
//
//    }
//
//    public List<List<Integer>> hasPathSum2(TreeNode root){
//
//
//    }


//    130. 被围绕的区域

    public void solve(char[][] board) {
        int a = board.length;
        if (a == 0){
            return;
        }
        int b = board[0].length;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || i == a-1 || j == 0 || j == b-1){
                    dfs ( board,i ,j);
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';

                }
            }
        }
    }

//    深度优先搜索
    public void dfs(char[][] board,int i,int j){
        int a = board.length;
        int b = board[0].length;
        if (i < 0 || i >= a || j < 0 || j >= b || board[i][j] != 'O'){
            return; // 越界
        }
        board[i][j] = 'A';
        dfs ( board,i-1 ,j);
        dfs ( board,i+1 ,j);
        dfs ( board,i ,j-1);
        dfs ( board,i ,j+1);

    }



}
