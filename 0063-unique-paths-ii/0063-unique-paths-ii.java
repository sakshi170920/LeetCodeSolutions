class Solution {
    public int helper(int[][] obstacleGrid,int i, int j)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //out of bounds or obstracle found
        if(i<0 || j<0 || i == m || j == n || obstacleGrid[i][j] == 1)
        {
            return 0;
        }
        //reached end
        if(i == m-1 && j == n-1)
        {
            return 1;
        }
        return helper(obstacleGrid,i,j+1) + helper(obstacleGrid,i+1,j);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0;i<m;i++)
        {
            int prevCol = 0;
            for(int j = 0;j<n;j++)
            {  
                if(obstacleGrid[i][j] == 1)
                {
                    dp[j] = 0;
                    prevCol = 0;
                    continue;
                }
                int result = 0; 
                result += prevCol;
                result += dp[j];
                prevCol = result;
                dp[j] = prevCol;
            }
        }
        return dp[n-1];
    }
}