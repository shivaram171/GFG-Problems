class Solution {
    public static int gcd(int a, int b) {
        // code here
       int min = Math.min(a,b);
        int max=Math.max(a,b);
        while(max!=0){
            int temp = max;
            max= min%max;
            min= temp;
            
        }
        return min;
    }
}
