class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePaths(m, n, obstacleGrid);
    }
    public int uniquePaths(int m, int n, int[][] obstacleGrid) {
        int memo[][] = new int[m][n];
        for (int row[] : memo) {
            Arrays.fill(row, -1);
        }
        return countPaths(m-1, n-1, memo, obstacleGrid);
    }
    public static int countPaths(int i, int j, int memo[][], int[][] obstacleGrid) {
        if (i>=0 && j>=0 && obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i==0 && j==0) { // reached our destination
            return 1;
        }
        if (i<0 || j<0) { // crossed the boundary of grid
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int up = countPaths(i-1, j, memo, obstacleGrid);
        int left = countPaths(i, j-1, memo, obstacleGrid);
        memo[i][j] = up+left;
        return memo[i][j];
    }
}
