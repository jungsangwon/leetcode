class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double result = 1D;
        double[] dp = new double[k+1];
        dp[0] = 1D;
        new21Game(1,maxPts,k,0D,dp);
        for(int i=Math.max(0,n-maxPts); i<=k-1; i++){
            result -= dp[i]*(i+maxPts-n)/maxPts;
        }
        return result;
    }
    
    public void new21Game(int now, int maxPts, int k, double val, double[] dp) {
        if(now<k){
            if(now-maxPts-1>=0){
                val -= dp[now-maxPts-1]/maxPts;
            }
            val += dp[now-1]/maxPts;
            dp[now] = val;
            new21Game(now+1,maxPts,k,val,dp);
        }
    }
}