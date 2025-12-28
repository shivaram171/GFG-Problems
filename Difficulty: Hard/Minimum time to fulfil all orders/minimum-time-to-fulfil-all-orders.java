class Solution {
    public int minTime(int[] ranks, int n) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;   // try smaller time
            } else {
                low = mid + 1;    // need more time
            }
        }
        return ans;
    }

    private boolean canMake(int[] ranks, int n, int time) {
        int count = 0;

        for (int r : ranks) {
            int t = 0;
            int k = 1;
            while (true) {
                t += r * k;
                if (t > time) break;
                count++;
                k++;
                if (count >= n) return true;
            }
        }
        return false;
    }
}
