import java.util.*;
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // rows
        int n = grid[0].length; // columns
        return (int) minPathSumTwo(m, n, grid);
    }
    public long minPathSumTwo(int m, int n, int grid[][]) {
        long memo[][] = new long[m][n];
        for (long row[] : memo) {
            Arrays.fill(row, -1);
        }
        return minPathSumThree(m-1, n-1, memo, grid);
    }
    public static long minPathSumThree(int i, int j, long memo[][], int grid[][]) {
        if (i==0 && j==0) return grid[0][0];
        if (i<0 || j<0) return (int) Math.pow(10,9);
        if (memo[i][j] != -1) return memo[i][j];
        long up = grid[i][j] + minPathSumThree(i-1, j, memo, grid);
        long left = grid[i][j] + minPathSumThree(i, j-1, memo, grid);
        memo[i][j] = Math.min(up, left);
        return memo[i][j];
        
    }
}
