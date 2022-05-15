class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int[][] check = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(check[i][j]==0&&grid[i][j]!='0'){
                    result++;
                    checking(grid,check,i,j);
                }
            }
        }
        return result;
    }
    
    public void checking(char[][] grid, int[][] check, int x, int y){
        check[x][y] = 1;
        if(x-1>=0&&grid[x-1][y]=='1'&&check[x-1][y]==0){
            checking(grid,check,x-1,y);
        }
        if(y-1>=0&&grid[x][y-1]=='1'&&check[x][y-1]==0){
            checking(grid,check,x,y-1);
        }
        if(x+1<grid.length&&grid[x+1][y]=='1'&&check[x+1][y]==0){
            checking(grid,check,x+1,y);
        }
        if(y+1<grid[0].length&&grid[x][y+1]=='1'&&check[x][y+1]==0){
            checking(grid,check,x,y+1);
        }
    }
}