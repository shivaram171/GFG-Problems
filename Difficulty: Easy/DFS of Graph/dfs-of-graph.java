// class Solution {
//     // Function to return a list containing the DFS traversal of the graph.
//     public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
//         // Code here
        
//     }
// }
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();   // number of vertices
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        // start DFS from node 0 (as per problem statement)
        dfsUtil(0, adj, visited, result);
        
        return result;
    }
    
    private void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited, result);
            }
        }
    }
}
