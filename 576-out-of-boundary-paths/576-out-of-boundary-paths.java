class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int result = 0;
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        for(int i=1;i<=maxMove;i++){
            result += findPaths(m,n,i,startRow,startColumn,dp);
            result %= 1000000007;
        }
        return result;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {
        int mod = 1000000007;
        if(dp[startRow][startColumn][maxMove]!=-1){
            return dp[startRow][startColumn][maxMove];
        }
        if(maxMove==1){
            int count = 0;
            if(startRow==0){
                count++;
            }
            if(startRow==m-1){
                count++;
            }
            if(startColumn==0){
                count++;
            }
            if(startColumn==n-1){
                count++;
            }
            dp[startRow][startColumn][maxMove] = count;
            return count;
        }else{
            int count = 0;
            if(startRow>0){
                count+=findPaths(m,n,maxMove-1,startRow-1,startColumn,dp);
                count%=1000000007;
            }
            if(startRow<m-1){
                count+=findPaths(m,n,maxMove-1,startRow+1,startColumn,dp);
                count%=1000000007;
            }
            if(startColumn>0){
                count+=findPaths(m,n,maxMove-1,startRow,startColumn-1,dp);
                count%=1000000007;
            }
            if(startColumn<n-1){
                count+=findPaths(m,n,maxMove-1,startRow,startColumn+1,dp);
                count%=1000000007;
            }
            dp[startRow][startColumn][maxMove] = count;
            return count;
        }
    }
}