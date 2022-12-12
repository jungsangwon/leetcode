class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        minCostClimbingStairs(cost,dp,0);
        return Math.min(dp[0],dp[1]);
    }
    
    public int minCostClimbingStairs(int[] cost, int[] dp, int idx) {
        if(idx>=cost.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int result = minCostClimbingStairs(cost,dp,idx+1);
        result = Math.min(result,minCostClimbingStairs(cost,dp,idx+2));
        dp[idx] = result+cost[idx];
        return dp[idx];
    }
}