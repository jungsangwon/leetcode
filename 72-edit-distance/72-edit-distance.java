class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0; i <= m; i++){
            for(int j=0; j <= n; j++){
                if(i == 0)  {
                    dp[i][j] = j;
                } else if(j == 0){
                    dp[i][j] = i;
                } else if(word1.charAt(i -1) == word2.charAt(j -1)){
                    dp[i][j] = dp[i-1][j-1];

                } else {

                    dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static int min(int x, int y, int z){
        if(x <= y && x <= z){
            return x;
        }
        if(y<=x && y<=z){
            return y;
        } else{
         return z;
        }
    }
      
}