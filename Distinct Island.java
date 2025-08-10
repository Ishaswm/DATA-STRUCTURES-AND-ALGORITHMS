import java.util.*;
// DFS
public class NumberOfDistinctIslands {

    public int countDistinctIslands(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        //traverse the grid
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                // if not visited and is a land cell
                if (vis[i][j]==0 && grid[i][j] == 1){
                    ArrayList<String> s = new ArrayList<>();
                    dfs(i, j, vis, grid, s, i, j);
                    //store it in HashSet
                    set.add(s);
                }
            }
        }
        return set.size();

    }
    public static void dfs(int row, int col, int vis[][], int grid[][], ArrayList<String> s, int row0, int col0){
        vis[row][col] = 1;
        s.add(toString(row-row0, col-col0));
        int n = grid.length;
        int m = grid[0].length;

        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, -1, 0, 1};
        for (int i=0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            // check for valid unvisited land neighbour coordinates
            if (nrow >=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow, ncol, vis, grid, s, row0, col0);
            }

        }

    }
    public static String toString(int r, int c){
        return Integer.toString(r)+" "+ Integer.toString(c);
    }
    public static void main(String[] args) {
        int grid[][] = {
        {1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {1, 1, 0, 1, 0}};

        NumberOfDistinctIslands ob = new NumberOfDistinctIslands();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);

    }
}
