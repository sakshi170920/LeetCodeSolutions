class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
       List<Set<Integer>> graph = new ArrayList();
       for(int i = 0;i<n;i++){
           graph.add(new HashSet());
       }
       for(int[] road : roads){
           graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
       } 
       int result = Integer.MIN_VALUE;
       for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int res = graph.get(i).size()+graph.get(j).size();
                if(graph.get(i).contains(j))
                    res--;
                result = Math.max(result,res);
            }
       }
       return result;
    }
}