class Solution {
    public boolean dfs(List<List<Integer>> graph,int src,int[] color,int prev)
    {
        //already handled
        if(color[src] != -1)
            return true;
        // color reverse of your adjacent i.e prev
        color[src] = reverse(prev);
        // loop over all neighbours of src
        for(int i = 0;i<graph.get(src).size();i++){
            int adj =  graph.get(src).get(i);
            // if adjacent not visited yet visit it
            if(color[adj] == -1 )
            {
                if(!dfs(graph,adj,color,color[src]))
                {
                    return false;
                }
            }
            //visited
            else
            {
                //if colors are same i.e xor = 1 then return false
                if((color[src]^color[adj]) == 0)
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
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //find number of nodes
        HashSet<Integer> set = new HashSet();
        List<List<Integer>> graph = new ArrayList();
        int len = 1;
        for(int i = 0;i<dislikes.length;i++)
        {
            len = Math.max(len,dislikes[i][0]);
            len = Math.max(len,dislikes[i][1]);
        }
        int[] color = new int[len];  
        //convert edges into adj list
        for(int i = 0;i<len;i++)
        {
            color[i] = -1;
            List<Integer> temp = new ArrayList();
            graph.add(temp);
        }
        System.out.println(len);      
        for(int i = 0;i<dislikes.length;i++)
        {
            graph.get(dislikes[i][0]-1).add(dislikes[i][1]-1);
            graph.get(dislikes[i][1]-1).add(dislikes[i][0]-1);
        }
        // for disconnected graph call for every loop
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