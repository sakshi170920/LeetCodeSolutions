class Solution {
    public int distance(int[] a,int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
    public int MST(List<List<Pair>> graph){
        int n = graph.size();
        PriorityQueue<Pair> q = new PriorityQueue<Pair>
        ((a,b)-> a.w - b.w);
        q.add(new Pair(0,0));
        //List<Pair> mst = new ArrayList();
        boolean[] visited = new boolean[n];
        int sum = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            // if(curr.src != -1){
            if(visited[curr.v])
                continue;              
            //mst.add(new Pair(curr.src, curr.dest));
            sum+= curr.w;
            visited[curr.v] = true;
            // }
            for(Pair edge : graph.get(curr.v)){
                if(!visited[edge.v])
                    q.add(new Pair(edge.v,edge.w));
            }
        }
        //System.out.println(mst);
        return sum;
    }
    public int minCostConnectPoints(int[][] points) {
        List<List<Pair>> graph = new ArrayList(points.length);
        for(int i = 0;i<points.length;i++){
            graph.add(new ArrayList());
        }
        for(int i = 0;i<points.length;i++){
            for(int j = 0;j<points.length;j++){
                if(i!=j){
                    int dist = distance(points[i],points[j]);
                    graph.get(i).add(new Pair(j,dist));
                    graph.get(j).add(new Pair(i,dist));
                }
            }  
        }
        //System.out.println(graph);
        return MST(graph);
    }
    class Pair{
        int v;
        int w;
        Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public String toString(){
            return this.v+" : "+this.w;
        }
    }
}