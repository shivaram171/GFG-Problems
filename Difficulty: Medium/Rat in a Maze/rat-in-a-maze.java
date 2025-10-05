import java.util.*;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        ArrayList<String> res = new ArrayList<>();
        
        // If start or end cell is blocked, no path possible
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
            return res;
        
        boolean[][] visited = new boolean[n][n];
        dfs(0, 0, maze, n, "", visited, res);
        
        Collections.sort(res); // ensure lexicographical order
        return res;
    }
    
    // DFS helper
    private void dfs(int i, int j, int[][] maze, int n, String path, boolean[][] visited, ArrayList<String> res) {
        // base case: reached destination
        if (i == n - 1 && j == n - 1) {
            res.add(path);
            return;
        }
        
        // mark as visited
        visited[i][j] = true;
        
        // direction arrays for D, L, R, U
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            
            // check validity
            if (isSafe(ni, nj, maze, visited, n)) {
                dfs(ni, nj, maze, n, path + dir[k], visited, res);
            }
        }
        
        // backtrack
        visited[i][j] = false;
    }
    
    private boolean isSafe(int i, int j, int[][] maze, boolean[][] visited, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && !visited[i][j]);
    }
}
