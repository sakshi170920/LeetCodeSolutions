class Solution {
    public int f(int index,int last,int[] nums,int[][] dp){
        if(index == nums.length)
        {
            return 0;
        }
        if(dp[index][last+1] == -1){
            int take = Integer.MIN_VALUE;
            if(last == -1 || nums[index]>nums[last])
            {
                take = 1+f(index+1,index,nums,dp);
            }
            int notTake = f(index+1,last,nums,dp);
            dp[index][last+1] = Math.max(take,notTake);
        }
        return dp[index][last+1];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0;i<dp.length;i++)
        {
            
                dp[i]= 1;
             
        }
        for(int i = 1;i<dp.length;i++)
        {
            for(int prev = 0;prev<i;prev++)
            {
                if(nums[prev]<nums[i])
                    dp[i] = Math.max(1+dp[prev],dp[i]);
            }  
        }
        int max = 1;
        for(int i = 0;i<dp.length;i++)
        {
             max = Math.max(max,dp[i]);
        }
        return max;
    }
}