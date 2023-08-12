class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> result = new ArrayList(n);
        for(int i = 0;i<n;i++)
        {
            result.add(new HashSet());
        }
        int[] indegree = new int[n];
        for(int[] edge : edges)
        {
            indegree[edge[1]]++;
        }
        List<List<Integer>> graph = new ArrayList(n);
        for(int i = 0;i<n;i++)
        {
            graph.add(new ArrayList());
        }
        for(int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
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
            for(int neighbour : graph.get(node))
            {
                result.get(neighbour).addAll(result.get(node));
                result.get(neighbour).add(node);
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                {
                    q.add(neighbour);
                }
            }
        }
        List<List<Integer>> res = new ArrayList(n);
        for(int i = 0;i<n;i++)
        {
            res.add(new ArrayList());
            List<Integer> temp = new ArrayList(result.get(i));
            Collections.sort(temp);
            res.get(i).addAll(temp);
        }
        return res;
    }
}