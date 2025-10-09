import java.util.*;

class Pair {
    int node, weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Step 1: Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // because undirected
        }

        // Step 2: Initialize distance and parent arrays
        int INF = (int) 1e9;
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= n; i++) parent[i] = i;
        dist[1] = 0; // start from node 1

        // Step 3: Dijkstra's algorithm using min-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 1}); // {dist, node}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int weight = p.weight;

                if (d + weight < dist[adjNode]) {
                    dist[adjNode] = d + weight;
                    parent[adjNode] = node;
                    pq.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        // Step 4: Reconstruct path from 1 to n
        if (dist[n] == INF) {
            return Arrays.asList(-1);
        }

        List<Integer> path = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);

        // Step 5: Add total distance at the beginning (optional)
        // Example: [5, 1, 4, 3, 5] → total distance 5
        List<Integer> result = new ArrayList<>();
        result.add(dist[n]); // total distance
        result.addAll(path);

        return result;
    }
}
