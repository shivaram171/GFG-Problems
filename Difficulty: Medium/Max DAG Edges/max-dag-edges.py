from collections import defaultdict, deque

class Solution:
    def maxEdgesToAdd(self, V, edges):
        adj = defaultdict(list)
        indegree = [0] * V
        
        for u, v in edges:
            adj[u].append(v)
            indegree[v] += 1
        
        # Topological Sort (Kahn's Algorithm)
        q = deque([i for i in range(V) if indegree[i] == 0])
        topo = []
        
        while q:
            node = q.popleft()
            topo.append(node)
            for nei in adj[node]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    q.append(nei)
        
        # Map each node to its position in topo order
        pos = {node: i for i, node in enumerate(topo)}
        
        # For each node, count how many outgoing edges go to *later* nodes
        existing_to_later = [0] * V
        for u, v in edges:
            if pos[u] < pos[v]:  # valid forward edge
                existing_to_later[u] += 1
        
        # Calculate total possible edges in a DAG following topo order
        total_possible = 0
        for i in range(V):
            total_possible += (V - i - 1) - existing_to_later[topo[i]]
        
        return total_possible
