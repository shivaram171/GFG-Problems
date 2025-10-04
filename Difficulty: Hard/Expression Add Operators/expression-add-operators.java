import java.util.*;

class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        dfs(s, target, 0, 0, 0, "", res);
        Collections.sort(res); // ensure lexicographically smallest order
        return res;
    }
    
    private void dfs(String s, int target, int index, long calc, long tail, String path, ArrayList<String> res) {
        int n = s.length();
        
        // Base case
        if (index == n) {
            if (calc == target) {
                res.add(path);
            }
            return;
        }
        
        // Explore all possible splits
        for (int i = index; i < n; i++) {
            // Skip numbers with leading zeros
            if (i > index && s.charAt(index) == '0') break;
            
            String currStr = s.substring(index, i + 1);
            long curr = Long.parseLong(currStr);
            
            // If first number, initialize expression
            if (index == 0) {
                dfs(s, target, i + 1, curr, curr, currStr, res);
            } else {
                // +
                dfs(s, target, i + 1, calc + curr, curr, path + "+" + currStr, res);
                // -
                dfs(s, target, i + 1, calc - curr, -curr, path + "-" + currStr, res);
                // *
                dfs(s, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + currStr, res);
            }
        }
    }
}
