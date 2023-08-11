class Solution {
    public void helper(int[][] graph,int src,List<Integer> temp,
    List<List<Integer>> result){
        if(src == graph.length-1)
        {
            result.add(new ArrayList(temp));
            return;
        }
        for(int node : graph[src])
        {
            temp.add(node);
            helper(graph,node,temp,result);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        temp.add(0);
        helper(graph,0,temp,result);
        return result;
    }
}