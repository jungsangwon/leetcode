class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int[][] profit = new int[prices.length][prices.length];
        int[] dp = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            for(int j=i+1;j<prices.length;j++){
                profit[i][j] = prices[j] - prices[i];
            }
        }
        Arrays.fill(dp,-1);
        maxProfit(profit,0,dp);
        return dp[0];
    }
    
    public int maxProfit(int[][] profit, int idx, int[] dp){
        int max = 0;
        if(idx>=profit.length){
            return max;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        for(int i=idx+1; i<profit.length; i++){
            if(profit[idx][i]>0){
                max = Math.max(max,profit[idx][i]+maxProfit(profit,i+2,dp));
            }
        }
        if(idx+1<profit.length){
            max = Math.max(max,maxProfit(profit,idx+1,dp));
        }
        dp[idx] = max;
        return max;
    }
}