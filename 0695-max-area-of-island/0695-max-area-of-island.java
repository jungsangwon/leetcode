class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    result = Math.max(result,maxAreaOfIsland(grid,i,j));
                }
            }
        }
        return result;
    }
     public int maxAreaOfIsland(int[][] grid, int x, int y) {
         int result = 1;
         grid[x][y] = 0;
         if(x+1<grid.length && grid[x+1][y]==1){
             result += maxAreaOfIsland(grid,x+1,y);
         }
         if(y+1<grid[x].length && grid[x][y+1]==1){
             result += maxAreaOfIsland(grid,x,y+1);
         }
         if(x-1>=0 && grid[x-1][y]==1){
             result += maxAreaOfIsland(grid,x-1,y);
         }
         if(y-1>=0 && grid[x][y-1]==1){
             result += maxAreaOfIsland(grid,x,y-1);
         }
        return result;
    }
}