class Solution {
    int m;
    int n;
    public int helper(int[][] grid,int i,int j,int[][] dp)
    { 
        if(i == 0 && j == 0)
        {
            dp[0][0] = grid[i][j];
            return dp[0][0];
        }
        if(i < 0 || j < 0)
        {
            return Integer.MAX_VALUE;
        }  
        if(dp[i][j] == -1)
        {     
            
            int left = helper(grid,i,j-1,dp);
            int up = helper(grid,i-1,j,dp);
            dp[i][j] = grid[i][j] + Math.min(left,up);
        }
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {   
        m = grid.length;
        n = grid[0].length; 
        int[][] dp = new int[m][n]; 
        for(int i = 0;i<m;i++)
        {
           for(int j = 0;j<n;j++)
            {
                dp[i][j] = 0;
            } 
        }      
        for(int i = 0;i<m;i++)
        {
           for(int j = 0;j<n;j++)
            {
                int min = Integer.MAX_VALUE;
                if(i == 0 && j == 0)
                {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if(i>0)
                    min = Math.min(min,dp[i-1][j]);
                if(j>0)
                    min = Math.min(min,dp[i][j-1]);
                dp[i][j] = grid[i][j] + min;

            } 
        }
        return dp[m-1][n-1];
    }
}