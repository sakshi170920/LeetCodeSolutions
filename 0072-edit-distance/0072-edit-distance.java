class Solution {
    public int helper(int i,int j,String word1, String word2,int[][] dp){
        if(dp[i][j] == -1){
            if(word1.charAt(i-1) == word2.charAt(j-1))
            {
                dp[i][j] = helper(i-1,j-1,word1,word2,dp);
            }
            else
            {
                int insert = 1+helper(i,j-1,word1,word2,dp);
                int delete = 1+helper(i-1,j,word1,word2,dp);
                int replace = 1+helper(i-1,j-1,word1,word2,dp);
                dp[i][j] = Math.min(insert,Math.min(delete,replace));
            }
        }
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<=m;i++)
        {
            for(int j = 0;j<=n;j++)
            {
                if(i == 0)
                    dp[0][j] = j;
                else if(j == 0)
                    dp[i][0] = i;
                else
                    dp[i][j] = -1;
            }
        }
        helper(m,n,word1,word2,dp);
        return dp[m][n];
    }
}