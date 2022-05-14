class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int num = 1;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for(int i=1; i<m; i++){
            if(obstacleGrid[i][0] == 1){
                num = 0;
            }
            obstacleGrid[i][0] = num;
        }
        num = 1;
        for(int i=1; i<n; i++){
            if(obstacleGrid[0][i] == 1){
                num = 0;
            }
            obstacleGrid[0][i] = num;
        }
        for(int i=1; i<m;i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        
        return obstacleGrid[m-1][n-1];
    }
}

