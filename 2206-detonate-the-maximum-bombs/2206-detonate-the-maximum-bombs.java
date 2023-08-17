class Solution {
    int n;
    public boolean isValid(int[] bomb1,int[] bomb2){
        //eucledian distance
        int xi = bomb1[0], yi = bomb1[1], ri = bomb1[2];
        int xj = bomb2[0], yj = bomb2[1];

        // Create a path from node i to node j, if bomb i detonates bomb j.
        if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
            return true;
        }
        return false;
    }
    public int dfs(int src,boolean[] visited,List<List<Integer>> graph){
        int count = 1;
        visited[src] = true;
        for(Integer v :  graph.get(src)){
           if(!visited[v]) {
               count += dfs(v,visited,graph);
            }
        }
        return count;

    }
    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList());
            for(int j = 0;j<n;j++){
                if(i!=j){
                    if(isValid(bombs[i],bombs[j]))
                        graph.get(i).add(j);
                }
            }
        }
        //System.out.println(graph);
        int result = 0;
        for(int i = 0;i<n;i++){
            boolean[] visited = new boolean[n];
            int count = dfs(i,visited,graph);
            // int count = 1;
            // for(int j = 0;j<n;j++){
            //     if(i!=j && visited[j]){
            //         count++;
            //     }
            // }
            result = Math.max(count,result);
        }
        return result;
    }
}