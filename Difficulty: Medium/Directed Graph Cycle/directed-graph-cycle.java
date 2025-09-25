import java.util.*;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Fill adjacency list and indegree
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        // Queue for nodes with 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // count thr number of processed nodes

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        // If count != V, there’s a cycle
        return count != V;
    }
}
