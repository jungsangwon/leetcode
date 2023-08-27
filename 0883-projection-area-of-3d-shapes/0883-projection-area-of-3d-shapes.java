class Solution {
    public int projectionArea(int[][] grid) {
        int result = 0;
        int n = grid.length;
        int[][] max = new int[n][2];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] != 0){
                    result++;
                    max[i][0] = Math.max(max[i][0],grid[i][j]);
                    max[j][1] = Math.max(max[j][1],grid[i][j]);
                }
            }
        }
        for(int i=0; i<n; i++){
            result += max[i][0];
            result += max[i][1];
        }
        return result;
    }
}