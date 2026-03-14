class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int min =prices[0];
        int max =0;
        
        for(int i =1; i<prices.length;i++){
            min = Math.min(min,prices[i] );
        int profit = prices[i]-min;
        max= Math.max(max, profit);
        }
        return max;
    }
}