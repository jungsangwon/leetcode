class Solution {
    public int integerBreak(int n) {
        int tmp = (int)Math.sqrt(n);
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=n; i++){
            int num1 = 2;
            int num2 = i-num1;
            do{
                dp[i] = Math.max(dp[i],Math.max(num1,dp[num1]) * Math.max(num2,dp[num2]));
                num1++;
                num2--;
            }while(num1<=num2);
        }
        
        
        return dp[n];
    }
}