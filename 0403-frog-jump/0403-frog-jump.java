class Solution {
    public boolean f(int idx,int last,int[] stones,
    HashMap<Integer,Integer> map,int[][] dp){
        if(idx == stones.length-1){
            return true; 
        } 
        if(dp[idx][last] != -1)
            return dp[idx][last] == 1;       
        int[] steps = {-1,0,1};
        boolean ans = false;
        for(int i = 0;i<steps.length;i++){
            int next = stones[idx]+last+steps[i];
            if(map.containsKey(next) && map.get(next)>idx){
                if(f(map.get(next),last+steps[i],stones,map,dp)){
                    dp[idx][last] = 1;
                    return true;
                }
            }
        }
        dp[idx][last] = 0;
        return false;
    }
    public boolean canCross(int[] stones) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        
        int[][] dp = new int[2001][2001];
        for(int i = 0;i<2000;i++){
           Arrays.fill(dp[i],-1);
        }
        
        return f(0,0,stones,map,dp);
    }
}