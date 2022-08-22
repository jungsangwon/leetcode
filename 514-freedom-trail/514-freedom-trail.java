class Solution {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[ring.length()][key.length()];
        return findRotateSteps(ring.toCharArray(),key.toCharArray(),0,0,dp);
    }
    
    public int findRotateSteps(char[] ring, char[] key, int r, int k, int[][] dp){
        if(k==key.length){
            return 0;
        }
        if(dp[r][k]!=0){
            return dp[r][k];
        }else{
            int min = Integer.MAX_VALUE;
            for(int i=0; i<ring.length; i++){
                if(ring[i]==key[k]){
                    int move = Math.abs(r-i);
                    move = Math.min(move,ring.length-move);
                    min = Math.min(min,move+1+findRotateSteps(ring,key,i,k+1,dp));
                }
            }
            dp[r][k] = min;
            return min;
        }
    }
}