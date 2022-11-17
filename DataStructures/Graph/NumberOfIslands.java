package DataStructures.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Island{
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int noOfIslands=0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == '1')
                {
                    searchIslands(grid, i, j, rows, cols);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private void searchIslands(char[][] grid, int x, int y, int rows, int cols)
    {
        if(x<0 || x>rows || y<0 || y>cols || grid[x][y] != '1')
            return;

        grid[x][y] = '2';

        searchIslands(grid, x-1, y, rows, cols);
        searchIslands(grid, x+1, y, rows, cols);
        searchIslands(grid, x, y-1, rows, cols);
        searchIslands(grid, x, y+1, rows, cols);
        searchIslands(grid, x-1, y+1, rows, cols);
        searchIslands(grid, x+1, y+1, rows, cols);
        searchIslands(grid, x+1, y-1, rows, cols);
        searchIslands(grid, x-1, y-1, rows, cols);
    }
}

public class NumberOfIslands {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Island island = new Island();
            int ans = island.numIslands(grid);
            System.out.println(ans);
        }
    }
}
