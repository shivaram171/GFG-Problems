import java.util.*;

class Solution {
    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        // Step 1: Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // undirected
        }

        // Step 2: Distance + visited arrays
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] visited = new boolean[V];

        // Step 3: Min-heap (PriorityQueue)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Pair(src, 0));

        // Step 4: Process PQ
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;

            if (visited[u]) continue;
            visited[u] = true;

            for (Pair nei : adj.get(u)) {
                int v = nei.node, w = nei.dist;
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
