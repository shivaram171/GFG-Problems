import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, int remainingSum, int remainingCount, 
                                  ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {
        // Base case
        if (remainingSum == 0 && remainingCount == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Invalid path
        if (remainingSum < 0 || remainingCount < 0) return;

        // Explore numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(i + 1, remainingSum - i, remainingCount - 1, curr, res);
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}
