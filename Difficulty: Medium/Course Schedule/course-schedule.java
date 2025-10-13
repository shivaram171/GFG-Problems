import java.util.*;

class Solution {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);  // prereq -> course
        }
        
        // Step 2: Compute indegree of each node
        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }
        
        // Step 3: Push all nodes with indegree = 0 into queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        
        // Step 4: BFS traversal
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        // Step 5: Check if topological sort includes all nodes
        if (topo.size() == n) return topo;  // valid ordering
        else return new ArrayList<>();       // cycle detected → no valid order
    }
}
