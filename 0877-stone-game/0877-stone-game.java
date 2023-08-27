class Solution {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][][] dp = new int[len][len][2];
        for(int i=0; i<len; i++){
            dp[i][i][1] = piles[i];
        }
        for(int i=0; i<len; i++){
            stoneGame(piles,i,i,0,dp);
        }
        return dp[0][len-1][0] > dp[0][len-1][1];
    }
    
    public void stoneGame(int[] piles, int start, int end, int idx, int[][][] dp){
        if(start > 0){
            int next;
            if(idx==0){
                next = dp[start][end][0]+piles[start-1];
                if(next>dp[start-1][end][0]){
                    dp[start-1][end][0]=next;
                    dp[start-1][end][1] = dp[start][end][1];
                    stoneGame(piles,start-1,end,1,dp);
                }
            }else{
                next = dp[start][end][1]+piles[start-1];
                if(next>dp[start-1][end][1]){
                    dp[start-1][end][1]=next;
                    dp[start-1][end][0] = dp[start][end][0];
                    stoneGame(piles,start-1,end,0,dp);
                }
            }
        }
        if(end < piles.length-1){
            int next;
            if(idx==0){
                next = dp[start][end][0]+piles[end+1];
                if(next>dp[start][end+1][0]){
                    dp[start][end+1][0]=next;
                    dp[start][end+1][1] = dp[start][end][1];
                    stoneGame(piles,start,end+1,1,dp);
                }
            }else{
                next = dp[start][end][1]+piles[end+1];
                if(next>dp[start][end+1][1]){
                    dp[start][end+1][1]=next;
                    dp[start][end+1][0] = dp[start][end][0];
                    stoneGame(piles,start,end+1,0,dp);
                }
            }
        }
    }
}