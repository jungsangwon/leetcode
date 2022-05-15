class Solution {
     
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        left[0] = 0;
        right[prices.length-1] = 0;
        
        int Lmin = prices[0];
        int Rmax = prices[prices.length-1];
        
        for(int i=1; i<prices.length; i++){
            left[i] = Math.max(left[i-1], prices[i]-Lmin);
            Lmin = Math.min(Lmin, prices[i]);
        }
        for(int i=prices.length-2; i>=0; i--){
            right[i] = Math.max(right[i+1], Rmax - prices[i]);
            Rmax = Math.max(Rmax, prices[i]);
        }
        
        int priceMax = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
            priceMax = Math.max(priceMax, left[i]+right[i]);
        }
        return priceMax;
    }
}