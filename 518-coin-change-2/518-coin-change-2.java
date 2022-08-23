class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[amount+1][coins.length];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return change(amount,coins,coins.length-1,dp);
    }
    
    public int change(int amount, int[] coins, int idx, int[][] dp){
        if(amount==0){
            return 1;
        }else if(idx==0){
            int result = 0;
            if(amount%coins[idx]==0){
                result = 1;
            }
            dp[amount][0] = result;
            return result;
        }
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }else{
            int result = 0;
            int tmp = amount;
            while(tmp>=0){
                result += change(tmp,coins,idx-1,dp);
                tmp-=coins[idx];
            }
            dp[amount][idx] = result;
            return result;
        }
    }
}