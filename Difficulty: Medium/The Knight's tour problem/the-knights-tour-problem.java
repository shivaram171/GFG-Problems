import java.util.*;

class Solution {
    // All 8 possible moves for a knight
    private static final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>(Collections.nCopies(n, -1)));
        }

        // starting position
        board.get(0).set(0, 0);

        // Start backtracking from (0, 0) with move count = 1
        if (solve(0, 0, 1, board, n)) {
            return board;
        } else {
            return new ArrayList<>(); // no solution possible
        }
    }

    private boolean solve(int x, int y, int move, ArrayList<ArrayList<Integer>> board, int n) {
        // If all cells are visited
        if (move == n * n) return true;

        // Try all 8 possible knight moves
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValid(nextX, nextY, board, n)) {
                board.get(nextX).set(nextY, move);
                if (solve(nextX, nextY, move + 1, board, n))
                    return true;
                // Backtrack
                board.get(nextX).set(nextY, -1);
            }
        }

        return false;
    }

    private boolean isValid(int x, int y, ArrayList<ArrayList<Integer>> board, int n) {
        return x >= 0 && y >= 0 && x < n && y < n && board.get(x).get(y) == -1;
    }
}
