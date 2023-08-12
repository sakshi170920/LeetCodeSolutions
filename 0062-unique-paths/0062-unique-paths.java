class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0;i<m;i++)
        {
            int prevCol = 0;
            for(int j = 0;j<n;j++)
            {  
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