class Solution {
    public int helper(int ind,int isBuy,int[] prices,int count,int[][][] dp){
        if(ind == prices.length)
        {
            return 0;
        }
        if(count == 0)
        {
            return 0;
        }
        if(dp[ind][isBuy][count-1] == -1){
            if(isBuy == 1){
                int take = -prices[ind] + helper(ind+1,0,prices,count,dp);
                int notTake = helper(ind+1,1,prices,count,dp);
                dp[ind][isBuy][count-1] = Math.max(take,notTake);
            }
            else {
                int take = prices[ind] + helper(ind+1,1,prices,count-1,dp);
                int notTake = helper(ind+1,0,prices,count,dp);
                dp[ind][isBuy][count-1] = Math.max(take,notTake);
            }
            
        }
        return dp[ind][isBuy][count-1];
    }
    public int maxProfit(int[] prices) {
        int noOfTransactions = 2;
        int[][][] dp=new int[prices.length][2][noOfTransactions];
        for(int i = 0;i<dp.length;i++)
        {
            for(int j = 0;j<dp[0].length;j++)
            {
                for(int k = 0;k<dp[0][0].length;k++)
                {
                    dp[i][j][k] = -1;
                }
            }
        }
        helper(0,1,prices,noOfTransactions,dp);
        return dp[0][1][noOfTransactions-1];
    }
}