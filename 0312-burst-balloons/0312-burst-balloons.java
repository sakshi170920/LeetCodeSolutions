class Solution {
    public int f(int i , int j,List<Integer> temp,int[][] dp){
        if(i>j)
            return 0;
        if(dp[i][j] == -1){
            int res = Integer.MIN_VALUE;
            for(int k = i;k<=j;k++){
                int val = temp.get(i-1) * temp.get(k) * temp.get(j+1);
                res = Math.max(res,val+f(i,k-1,temp,dp)+f(k+1,j,temp,dp));
            }
            dp[i][j] = res;
        }
        return dp[i][j];
    }
    public int maxCoins(int[] nums) {
        List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        temp.add(0,1);
        temp.add(1);
        System.out.println(temp);
        int[][] dp = new int[temp.size()][temp.size()];
        for(int i = 0;i<dp.length;i++)
        {
            for(int j = 0;j<dp.length;j++){
                dp[i][j] = -1;
            }
        }
        return f(1,nums.length, temp,dp);
    }
}