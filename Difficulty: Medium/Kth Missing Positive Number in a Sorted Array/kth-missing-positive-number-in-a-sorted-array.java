class Solution {
    public int kthMissing(int[] arr, int k) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int missing = arr[i] - (i + 1);

            if (missing >= k) {
                return i + k;
            }
        }

        // if kth missing is beyond last element
        return n + k;
    }
}
