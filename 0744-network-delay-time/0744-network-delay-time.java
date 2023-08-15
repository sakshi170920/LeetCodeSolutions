class Solution {
    public int djikshtra(List<List<Pair<Integer,Integer>>> graph,int k){
        int n = graph.size();
        int[] dist = new int[n];
        for(int i = 0;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k-1] = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair<Integer,Integer>> q = new 
        PriorityQueue<Pair<Integer,Integer>>((a,b)->a.getKey()-b.getKey());
        q.add(new Pair(0,k-1));
        while(!q.isEmpty()){
            // gives vertex with min dist from source
            int u = q.poll().getValue();  
            visited[u] = true;
            //update dist of neighbours of curr index
            for(Pair<Integer,Integer> neighbour : graph.get(u)){
                int v = neighbour.getKey();
                int w = neighbour.getValue();
                if(dist[v]>dist[u]+w){
                    dist[v] = dist[u]+w;
                    q.add(new Pair(dist[v],v));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max,dist[i]);
        }
        return max;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer,Integer>>> graph = new ArrayList();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList());
        }
        for(int i = 0;i<times.length;i++){
            graph.get(times[i][0]-1).add(new Pair(times[i][1]-1,times[i][2]));
        }
        return djikshtra(graph,k);
    }
}