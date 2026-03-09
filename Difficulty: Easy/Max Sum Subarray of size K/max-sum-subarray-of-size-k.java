class Solution {
    public int maxSubarraySum(int[] arr, int k) {


int n = arr.length;

int window = 0;
for(int i =0;i< k;i++){
    window = window+arr[i];
}
int max = window;


for(int i =k;i<n;i++){
    window = window + arr[i];
    window = window - arr[i-k];
    
    max = Math.max(max, window);
    
}

return max;

    }
}