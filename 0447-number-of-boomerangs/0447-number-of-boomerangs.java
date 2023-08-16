class Solution {
    public int distance(int[] x,int[] y){
        return (x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]);
    }
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        int n = points.length;
        int[][] graph = new int[n][n];
        for(int i = 0;i<points.length;i++){
            HashMap<Integer,Integer> map = new HashMap();
            for(int j = 0;j<points.length;j++){         
                int dist = distance(points[i],points[j]);         
                map.put(dist,map.getOrDefault(dist,0)+1);     
            }
            for(Integer count : map.values()){
                if(count>=2)
                    result+= count*(count-1);
            }
        }                   
        return result;
    }
}