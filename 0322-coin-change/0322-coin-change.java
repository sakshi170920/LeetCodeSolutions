class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0;i<dp.length;i++)
        {
            for(int j = 0;j<dp[0].length;j++)
            {
                dp[i][j] = -1;
            }
        }
        for(int j = 0;j<dp[0].length;j++)
        {
            if(j%coins[0] == 0)
            {
                dp[0][j] = j/coins[0];
            }
            else
                dp[0][j] = Integer.MAX_VALUE;
        }
        for(int i = 1;i<dp.length;i++)
        {
            for(int j = 0;j<dp[0].length;j++)
            {
                int take = Integer.MAX_VALUE;
                if(coins[i]<=j)
                {
                    int temp = dp[i][j-coins[i]];
                    if(temp != Integer.MAX_VALUE)
                    {
                        take = 1+temp;
                    }
                }
                int notTake = dp[i-1][j];
                dp[i][j] = Math.min(take,notTake);
            }
        }
        int result = dp[coins.length-1][amount];
        return  result == Integer.MAX_VALUE ? -1 : result;
    }
}