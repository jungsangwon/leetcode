class Solution {
    public int maxProfit(int[] prices) {
        int max =0, currMax= 0;
        
        for(int i=1;i<prices.length;i++){
            currMax += prices[i] - prices[i-1];
            
            if(currMax < 0){
                currMax = 0;
            }
            
            if(currMax>max){
                max=currMax;
            }
            
        }
        
        return max;
    }
    
}