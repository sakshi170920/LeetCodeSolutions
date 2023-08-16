class Solution {
    public int distance(int[] x,int[] y){
        return (x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]);
    }
    public int permutations(int x){
        return fact(x)/fact(x-2);
    }
    public int fact(int x){
        if(x<=1)
            return 1;
        return x*fact(x-1);
    }
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int[][] graph = new int[n][n];
        for(int i = 0;i<points.length;i++){
            for(int j = i+1;j<points.length;j++){         
                int dist = distance(points[i],points[j]);         
                graph[i][j] = dist;
                graph[j][i] = dist;          
            }
        }
        int result = 0;
        for(int i = 0;i<points.length;i++){
            HashMap<Integer,List<Integer>> map = new HashMap();
             for(int j = 0;j<points.length;j++){         
                if(i!=j){
                    if(map.containsKey(graph[i][j])){
                        map.get(graph[i][j]).add(j);
                    }
                    else{
                        List<Integer> arr = new ArrayList();
                        arr.add(j);
                        map.put(graph[i][j],arr);
                    }
                }
            }
            //System.out.println(map);
            for(List<Integer> arr : map.values()){
                if(arr.size()>=2)
                    result+= permutations(arr.size());
            }
        }
        return result;
    }
}