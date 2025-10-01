import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // Sort to handle duplicates & ensure lexicographical order
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), used, result);
        return result;
    }
    
    private static void backtrack(int[] arr, ArrayList<Integer> current, boolean[] used, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            // Skip already used numbers
            if (used[i]) continue;
            
            // Skip duplicates (only if previous duplicate hasn't been used yet)
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;
            
            // Choose
            used[i] = true;
            current.add(arr[i]);
            
            // Recurse
            backtrack(arr, current, used, result);
            
            // Backtrack
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
