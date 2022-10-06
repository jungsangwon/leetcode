class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = i;
        }
        int limit = n/2;
        for(int i=2; i<=limit; i++){
            int now = i+i;
            int count = dp[i]+1;
            while(now<=n){
                count++;
                dp[now] = Math.min(dp[now],count);
                now += i;
            }
        }
        return dp[n];
    }
}