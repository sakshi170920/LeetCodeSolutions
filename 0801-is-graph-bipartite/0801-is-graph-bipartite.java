class Solution {
    public boolean dfs(int[][] graph,int src,int[] color,int prev)
    {
        if(color[src] != -1)
            return true;
        color[src] = reverse(prev);
        for(int i = 0;i<graph[src].length;i++){
            int adj =  color[graph[src][i]];
            if(adj == -1 )
            {
                if(!dfs(graph,graph[src][i],color,color[src]))
                {
                    return false;
                }
            }
            else
            {
                if((color[src]^color[graph[src][i]]) == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public int reverse(int x)
    {
        if(x == 0) return 1;                   
        if(x == 1) return 0;
        return -1;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0;i<color.length;i++)
        {
            color[i] = -1;
        }
        for(int i = 0;i<color.length;i++)
        {
            if(!dfs(graph,i,color,1))
            {
                return false;
            }
        }
        return true;
    }
}