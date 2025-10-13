import java.util.*;

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }

        // Compute in-degree
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int nbr : adj.get(i)) {
                indegree[nbr]++;
            }
        }

        // Step 3: Push all nodes with indegree 0 into queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // Step 4: Perform BFS
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int nbr : adj.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) q.add(nbr);
            }
        }

        return topo;
    }
}
