class Solution {
    public int nthFibonacci(int n) {
        // Base cases
        if (n < 2) {
            return n;
        }
        
        // Recursive relation
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }
}
