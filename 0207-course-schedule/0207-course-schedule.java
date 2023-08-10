class Solution {
    //modifying bfs because its possible that someone at third level has dependency edge to 1st level
    public List<Integer> topologicalSort(List<List<Integer>> graph)
    {
        List<Integer> result = new ArrayList();
        int n = graph.size();
        //calculate indegrees
        int[] indegree = new int[n];
        for(List<Integer> node : graph)
        {
            for(int j = 0;j<node.size();j++)
            {
                indegree[node.get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList();
        for(int i = 0;i<n;i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int node = q.poll();
            result.add(node);
            for(Integer neighbour : graph.get(node))
            {            
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                {
                    q.add(neighbour);
                }
            }
        }
        return result;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList();
        //create adj list
        for(int i = 0;i<numCourses;i++)
        {
            List<Integer> temp = new ArrayList();
            graph.add(temp);
        }
        for(int i = 0;i<prerequisites.length;i++)
        {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        List<Integer> result = topologicalSort(graph);
        return result.size() == numCourses ? true : false;
    }
}