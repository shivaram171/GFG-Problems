import java.util.*;

class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0, bestStart = 0, bestLen = 0;

        for (int right = 0; right < n; right++) {
            // Maintain minDeque (increasing order)
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // Maintain maxDeque (decreasing order)
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // Shrink window if invalid
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                left++;
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
            }

            // Update best result
            if (right - left + 1 > bestLen) {
                bestLen = right - left + 1;
                bestStart = left;
            }
        }

        // Build answer
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = bestStart; i < bestStart + bestLen; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
