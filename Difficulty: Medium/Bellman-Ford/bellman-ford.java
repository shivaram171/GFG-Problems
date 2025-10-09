// User function Template for Java

import java.util.*;

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int INF = 100000000; // a large number (infinity)
        int[] dist = new int[V]; 

        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (dist[u] != INF && dist[u] + w < dist[v]) {
              
                return new int[]{-1};
            }
        }

        return dist; 
    }
}
