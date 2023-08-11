class Solution {
    public int dfs(int i,int j, int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = {1,-1,0,0};
        int[] cols = {0,0,1,-1};
        grid[i][j] = 0;
        int result = 1;
        for(int k = 0;k<rows.length;k++)
        {
            int row = i+rows[k];
            int col = j+cols[k];
            if(row>=0 && col>=0 && row<m && col<n && grid[row][col] == 1)
            {
                result +=  dfs(row,col,grid);
            }
        }
        return result;       
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == 1)
                {
                    res = Math.max(res,dfs(i,j,grid));
                }
            }
        }
        return res;
    }
}