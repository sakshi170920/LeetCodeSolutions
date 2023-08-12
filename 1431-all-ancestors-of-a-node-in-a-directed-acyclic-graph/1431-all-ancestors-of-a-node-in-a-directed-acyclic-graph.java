class Solution {
    public void dfs(int src,int ancestor,List<List<Integer>> graph,List<List<Integer>> result){
        for(Integer child : graph.get(src))
        {
            List<Integer> ancestors = result.get(child);
            //we dont need visited array if in the given 
            //traversal of finding all descendants of ancestor 
            //if any child already has it , skip it
            if(ancestors.isEmpty() || ancestors.get(ancestors.size()-1) != ancestor)
            {
                result.get(child).add(ancestor);
                dfs(child,ancestor,graph,result);
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
            //start with src = 0 and traverse all children of 0 and 
            //add it as ancesstor
            // then start with 1 
            // do it for all nodes 1 by 1 so order is maintained, 
            //however more traversals
            dfs(i,i,graph,result);
            
        }
        return result;
    }
}