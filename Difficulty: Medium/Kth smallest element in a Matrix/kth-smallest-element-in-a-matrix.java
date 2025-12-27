import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;

        // Min heap: {value, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Insert first element of each row
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{mat[i][0], i, 0});
        }

        int ans = 0;

        while (k-- > 0) {
            int[] curr = pq.poll();
            ans = curr[0];
            int r = curr[1];
            int c = curr[2];

            // Push next element from same row
            if (c + 1 < n) {
                pq.offer(new int[]{mat[r][c + 1], r, c + 1});
            }
        }
        return ans;
    }
}
