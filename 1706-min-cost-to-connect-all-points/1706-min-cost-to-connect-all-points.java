class Solution {
    public int distance(int[] a,int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
    public int getParent(int v, int[] parent){
        int curr = v;
        while(parent[curr]>=0){
            curr = parent[curr];
        }
        // collapsing, assigning directly to final parent
        if(parent[v] > 0)
            parent[v] = curr;
        return curr;
    }
    public int MSTwithKruskal(PriorityQueue<int[]> q,int v){
        //parent array
        int[] parent = new int[v];
        int cost = 0;
        // -ve indicates it is its own parent , value indicates no of nodes
        // +ve value indicates its direct parent
        Arrays.fill(parent,-1);
        while(!q.isEmpty()){
            int[] edge = q.poll();
            int p1 = getParent(edge[0],parent);
            int p2 = getParent(edge[1],parent);
            if(p1 == p2){
                continue; // skip because it forms cycle
            }else{
                cost += edge[2];
                // -4 and -2 , select smaller (more nodes)
                if(parent[p1] <= parent[p2]){
                    // increase no of nodes
                    parent[p1] += parent[p2];
                    // assign p2's parent as p1
                    parent[p2] = p1;
                }
                else{
                    parent[p2] += parent[p1];
                    parent[p1] = p2;
                }
            }
        }
        return cost;
    }
    public int MSTwithPrim(List<List<Pair>> graph){
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
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
        for(int i = 0;i<points.length;i++){
            for(int j = 0;j<points.length;j++){
                if(i!=j){
                    int dist = distance(points[i],points[j]);
                    int[] res = new int[3];
                    res[2] = dist;
                    res[0] = i;
                    res[1] = j;
                    q.add(res);
                    graph.get(i).add(new Pair(j,dist));
                    graph.get(j).add(new Pair(i,dist));
                }
            }  
        }
        //System.out.println(graph);
        return MSTwithKruskal(q,points.length);
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