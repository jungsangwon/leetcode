class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(n>=2){
            dp[2] = 2;
        }
        for(int i=3; i<=n; i++){
            calculate(i,dp);
        }
        return dp[n];
    }
    
    public void calculate(int n, int[] dp){
        int left = 0;
        int right = n-1;
        for(int i=1; i<=n; i++){
            dp[n] += dp[left] * dp[right];
            left++;
            right--;
        }
    }
}