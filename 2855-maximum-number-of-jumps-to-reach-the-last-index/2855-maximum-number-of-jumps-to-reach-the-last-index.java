class Solution {
    public int f(int index,int[] nums, int target, int[] dp){
        if(index == nums.length - 1)
            return 0;
        if(dp[index] != -1)
            return dp[index];
        int res = Integer.MIN_VALUE;
        for(int i = index+1;i<nums.length;i++){
            if(Math.abs(nums[i] - nums[index])<= target)
            {
                int temp = f(i,nums,target,dp);
                if(temp != Integer.MIN_VALUE)
                    res = Math.max(res,1+temp);
            }
        }
        dp[index] = res;
        return res;
    }
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length-1];
        Arrays.fill(dp,-1);
        f(0,nums,target,dp);
        return dp[0] == Integer.MIN_VALUE ? -1 : dp[0];
    }
}