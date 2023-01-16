class Solution {
    public int swimInWater(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<grid.length; i++){
            for(int j =0; j<grid[i].length; j++){
                min = Math.min(min,grid[i][j]);
                max = Math.max(max,grid[i][j]);
            }
        }
        while(min<max){
            int mid = (min+max)/2;
            if(canSwim(grid,mid)){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return max;
    }
    
    public boolean canSwim(int[][] grid, int t){
        boolean[][] visit = new boolean[grid.length][grid.length];
        go(grid,t,visit,0,0);
        return visit[grid.length-1][grid.length-1];
    }
    
    public void go(int[][] grid, int t, boolean[][] visit, int x, int y){
        if(grid[x][y]<=t){
            visit[x][y] = true;
            int[] moveX = {0,0,1,-1};
            int[] moveY = {1,-1,0,-0};
            for(int i=0; i<4; i++){
                int nextX = x+moveX[i];
                int nextY = y+moveY[i];
                if(nextX>=0 && nextX<grid.length&&nextY>=0 && nextY<grid.length&&!visit[nextX][nextY]){
                    go(grid,t,visit,nextX,nextY);
                }
            }
        }
    }
}