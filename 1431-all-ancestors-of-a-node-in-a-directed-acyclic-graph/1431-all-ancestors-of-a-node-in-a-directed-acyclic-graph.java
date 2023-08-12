class Solution {
    public void dfs(int src,int ancestor,List<List<Integer>> graph,boolean[] visited,List<List<Integer>> result){
        visited[src] = true;
        for(Integer child : graph.get(src))
        {
            if(!visited[child])
            {
                result.get(child).add(ancestor);
                dfs(child,ancestor,graph,visited,result);
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList();
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0;i<n;i++)
        {
            result.add(new ArrayList());
            graph.add(new ArrayList());
        }
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
        }
        for(int i = 0;i<n;i++)
        {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            //start with src = 0 and traverse all children of 0 and add it as ancesstor
            // then start with 1 
            // do it for all nodes 1 by 1 so order is maintained, however more traversals
            dfs(i,i,graph,visited,result);
            
        }
        return result;
    }
}