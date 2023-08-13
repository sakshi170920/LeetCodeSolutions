class Solution {
    public int minPathSum(int[][] grid) {   
        int m = grid.length;
        int n = grid[0].length; 
        int[] dp = new int[n];  
        for(int i = 0;i<n;i++)
        {
            dp[i] = Integer.MAX_VALUE;
        } 
        dp[0] = grid[0][0];   
        for(int i = 0;i<m;i++)
        {
            int prevCol = Integer.MAX_VALUE; 
            for(int j = 0;j<n;j++)
            {
                if(i == 0 && j == 0)
                {
                    prevCol = dp[j];
                    continue;
                }
                int min = Integer.MAX_VALUE;               
                min = Math.min(min,dp[j]);
                min = Math.min(min,prevCol);
                dp[j] = grid[i][j] + min;
                prevCol = dp[j];
            } 
        }
        return dp[n-1];
    }
}