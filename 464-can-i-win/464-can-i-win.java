class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0){
          return true;  
        }else if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal){
            return false;            
        } 
        int[] dp = new int[1 << maxChoosableInteger];
        return dfs(dp, 0, maxChoosableInteger, desiredTotal);
    }
    
    public boolean dfs(int[] dp, int now, int max, int target) {
        if (target <= 0){
            return false;            
        } 
        if (dp[now] != 0){
          return dp[now] == 1;  
        } 
        boolean win = false;
        for (int i = 0; i < max; i++) {
            if ((now & (1 << i)) == 0) {
                win = win || !dfs(dp, now ^ (1 << i), max, target - i - 1);
            }
        }
        dp[now] = win ? 1 : -1;
        return win;
    }
}