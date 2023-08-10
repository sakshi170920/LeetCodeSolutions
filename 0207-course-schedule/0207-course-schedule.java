class Solution {
    public boolean isCycle(List<List<Integer>> graph,int src,
    int[] visited)
    {
        if(visited[src] == 1)
            return true;
        if(visited[src] == 2)
            return false; 
        List<Integer> neighbours = graph.get(src);
        if(neighbours.isEmpty())
        {
            return false;
        }
        visited[src] = 1;
        for(int i = 0;i<neighbours.size();i++)
        {
            if(isCycle(graph,neighbours.get(i),visited))
            {
                return true;
            }
        }
        visited[src] = 2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0;i<numCourses;i++)
        {
            List<Integer> temp = new ArrayList();
            graph.add(temp);
        }
        for(int i = 0;i<prerequisites.length;i++)
        {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 0 : unvisited
        // 1 : visited - same path
        // 2 : visited and already processed
        int[] visited =new int[numCourses];
        for(int i = 0;i<numCourses;i++)
        {
            visited[i] = 0;
        }
        System.out.println(graph);
        for(int i = 0;i<numCourses;i++)
        {
            if(visited[i] == 0 && isCycle(graph,i,visited))
            {
                return false;
            }
            //System.out.println(Arrays.toString(visited));
        }
        return true;
    }
}