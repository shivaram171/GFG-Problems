// class Solution {
//     // Function to return Breadth First Search Traversal of given graph.
//     public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        
//         // create a set of inteber = new hash set
//         // code here
         
//     }
// }
import java.util.*;

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>(); // 

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            for (int n : adj.get(vertex)) {
                if (!visited.contains(n)) { 
                    visited.add(n);
                    queue.add(n);
                }
            }
        }

        return result;
    }
}

