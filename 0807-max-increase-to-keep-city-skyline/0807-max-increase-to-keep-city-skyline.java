class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        int n = grid.length;
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                x[i] = Math.max(x[i],grid[i][j]);
                y[j] = Math.max(y[j],grid[i][j]);
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = Math.min(x[i],y[j]);
                if(tmp>grid[i][j]){
                    result += tmp - grid[i][j];
                }
            }
        }
        
        return result;
    }
}