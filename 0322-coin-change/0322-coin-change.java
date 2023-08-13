class Solution {
    public int helper(int[] coins,int index,int amount,int[][] dp)
    {
        if(index == 0)
        {
            if(amount%coins[0] == 0)
            {
                dp[0][amount] = amount/coins[0];
                return amount/coins[0];
            }
            dp[0][amount] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        if(dp[index][amount] == -1)
        {
        int take = Integer.MAX_VALUE;
        if(coins[index]<=amount)
        {
            int temp = helper(coins,index,amount-coins[index],dp);
            if(temp == Integer.MAX_VALUE)            
                take = temp;       
            else
                take = 1+temp;
        }
        int notTake = helper(coins,index-1,amount,dp);  
        dp[index][amount] = Math.min(take,notTake);
        }
        return dp[index][amount];
    }
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
        helper(coins,coins.length-1,amount,dp);
        int result = dp[coins.length-1][amount];
        return  result == Integer.MAX_VALUE ? -1 : result;
    }
}