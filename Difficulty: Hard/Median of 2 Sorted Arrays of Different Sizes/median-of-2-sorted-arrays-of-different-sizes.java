

class Solution {
    public double medianOf2(int a[], int b[]) {

    
        int[] merged = new int[a.length + b.length];

    
        System.arraycopy(a, 0, merged, 0, a.length);
        System.arraycopy(b, 0, merged, a.length, b.length);

    
        Arrays.sort(merged);

        int n = merged.length;
        if (n % 2 == 1) {
            return merged[n / 2]; 
        } else {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;  
        }
    }
}
