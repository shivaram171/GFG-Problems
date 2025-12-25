import java.util.*;

class Solution {
    public int kthSmallest(int[] arr, int k) {

        Arrays.sort(arr);   // sort array

        return arr[k - 1];  // k-th smallest (1-based index)
    }
}
