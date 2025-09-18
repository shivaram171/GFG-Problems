import java.util.*;

class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        // Traverse 2*n times in reverse order
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            // Pop smaller or equal elements
            while (!st.isEmpty() && arr[st.peek()] <= arr[idx]) {
                st.pop();
            }


            if (!st.isEmpty()) {
                res.set(idx, arr[st.peek()]);
            }
            st.push(idx);
        }

        return res;
    }
}
