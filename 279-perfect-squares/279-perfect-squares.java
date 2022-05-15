class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 1;
        for(int i =2; i<=n; i++){
            numSquares(i,dp);
        }
        return dp[n];
    }
    
    public void numSquares(int n, int[] dp) {
        int limit = (int)Math.sqrt(n);
        if(limit*limit == n){
            dp[n] = 1;
        }else{
            for(int i=1; i<=limit; i++){
                dp[n] = Math.min(dp[n],dp[n-(i*i)]+1);
            }
        }
    }
}