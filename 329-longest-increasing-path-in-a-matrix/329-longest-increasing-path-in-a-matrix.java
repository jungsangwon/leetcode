class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                max = Math.max(max,longestIncreasingPath(matrix,dp,i,j));
            }
        }
        
        return max;
    }
    
    public int longestIncreasingPath(int[][] matrix, int[][] dp, int x, int y){
        int max=0;
        if(dp[x][y]!=0){
            return dp[x][y];
        }
        if(x-1>=0 && matrix[x-1][y]<matrix[x][y]){
            max = Math.max(max,longestIncreasingPath(matrix,dp,x-1,y));
        }
        if(x+1<matrix.length && matrix[x+1][y]<matrix[x][y]){
            max = Math.max(max,longestIncreasingPath(matrix,dp,x+1,y));
        }
        if(y-1>=0 && matrix[x][y-1]<matrix[x][y]){
            max = Math.max(max,longestIncreasingPath(matrix,dp,x,y-1));
        }
        if(y+1<matrix[x].length && matrix[x][y+1]<matrix[x][y]){
            max = Math.max(max,longestIncreasingPath(matrix,dp,x,y+1));
        }
        dp[x][y] = max+1;
        return dp[x][y];
    }
}