class Solution {
    public int helper(int i ,int j,String p, String s,int[][] dp){
        //System.out.println("i:"+i+" j:"+j);
        if(dp[i][j] == -1)
        {
            // if(i<0 && j<0)
            //     return true;
            // if(i<0)
            //     return false;
            // if(i == 0 && j< 0 && p.charAt(0) == '*')
            //     return true;
            // if(j<0)
            //     return false;
            //System.out.println(p.substring(0,i+1)+" : "+s.substring(0,j+1));
            if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?')
            {
                dp[i][j] = helper(i-1,j-1,p,s,dp);
            }
            else
            {
                if(p.charAt(i-1) == '*')
                    dp[i][j] = helper(i,j-1,p,s,dp) | helper(i-1,j,p,s,dp);
                else
                    dp[i][j] =  0;
            }
        }
        return dp[i][j];
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        StringBuilder t = new StringBuilder(p);
        for(int i = 0;i<t.length()-1;i++)
        {
            if(t.charAt(i) == '*' && t.charAt(i+1) == '*')
            {
                t.delete(i,i+1);
                i--;
            }
        }
        p = t.toString();
        int m = p.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<=m;i++)
        {
            for(int j = 0;j<=n;j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;
        if(m == 0 && n == 0)
            return true;
        if( m == 0)
            return false;
        if(p.charAt(0) == '*')
           dp[1][0] = 1; 
        helper(m,n,p,s,dp);
        return  dp[m][n] == 1 ? true : false;
    }
}