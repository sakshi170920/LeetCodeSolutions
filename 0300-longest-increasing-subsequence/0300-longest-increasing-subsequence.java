class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0;i<dp.length;i++)
        {
            
                dp[i]= 1;
             
        }
        int max = 1;
        for(int i = 1;i<dp.length;i++)
        {
            for(int prev = 0;prev<i;prev++)
            {
                if(nums[prev]<nums[i])
                    dp[i] = Math.max(1+dp[prev],dp[i]);
            }
            max = Math.max(max,dp[i]);  
        }
        return max;
    }
}