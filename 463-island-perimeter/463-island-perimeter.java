class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    sum += getPerimeter(grid, i, j);
                }
            }
        }
        return sum;
    }
    
    public int getPerimeter(int[][] grid, int x, int y){
        int count = 0;
        if(x-1<0 || grid[x-1][y]==0){
            count++;
        }
        if(y-1<0 || grid[x][y-1]==0){
            count++;
        }
        if(x+1>=grid.length || grid[x+1][y]==0){
            count++;
        }
        if(y+1>=grid[x].length || grid[x][y+1]==0){
            count++;
        }
        return count;
    }
}