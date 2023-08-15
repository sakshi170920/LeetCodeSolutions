class Solution {
    public int djikshtra(List<List<Pair<Integer,Integer>>> graph,int k){
        int n = graph.size();
        int[] dist = new int[n];
        for(int i = 0;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k-1] = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList();
        while(true){
            int min=Integer.MAX_VALUE;
            int min_ind=-1;
            // find vertex with min dist from source
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    if(dist[i]<min){
                        min = dist[i];
                        min_ind = i; 
                        System.out.println("found min "+(i+1));
                    }
                }
            }
            // cannot reach the source
            if(min_ind == -1)
            {
                break;
            }
            q.add(min_ind);
            visited[min_ind] = true;

            //update dist of neighbours of curr index
            for(Pair<Integer,Integer> neighbour : graph.get(min_ind)){
                int v = neighbour.getKey();
                int w = neighbour.getValue();
                if(dist[v]>dist[min_ind]+w){
                    dist[v] = dist[min_ind]+w;
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