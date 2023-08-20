class Solution {
    public boolean f(int idx,int[] nums,int[] dp){
        if(dp[idx] != -1)
            return dp[idx] == 1;
        if(idx == nums.length-1)
        {
            dp[idx] = 1;
            return true;
        }
        for(int i = 1 ;i<=nums[idx] && i<nums.length;i++){
            if(f(idx+i,nums,dp)){
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return f(0,nums,dp);
    }
}