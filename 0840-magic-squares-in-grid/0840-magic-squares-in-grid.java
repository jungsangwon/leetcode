class Solution {
    int[] base = {1,6,7,2,9,4,3,8};
    public int numMagicSquaresInside(int[][] grid) {
        int result=0;
        int n = grid.length;
        int m = grid[0].length;
        if(n<3 || m<3){
            return result;
        }
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(grid[i][j]==5 && check(grid,i,j)){
                    result++;
                }
            }
        }
        return result;
    }
    
    public boolean check(int[][] grid, int x, int y){
        int[] tmp = new int[8];
        tmp[0] = grid[x-1][y];
        tmp[1] = grid[x-1][y+1];
        tmp[2] = grid[x][y+1];
        tmp[3] = grid[x+1][y+1];
        tmp[4] = grid[x+1][y];
        tmp[5] = grid[x+1][y-1];
        tmp[6] = grid[x][y-1];
        tmp[7] = grid[x-1][y-1];
        
        int idx2=0;
        for(; idx2<8; idx2++){
            if(base[0]==tmp[idx2]){
                break;
            }
        }
        
        if(idx2==8){
            return false;
        }else{
            if((idx2==7&&tmp[0]==6)||(idx2!=7 &&tmp[idx2+1]==6)){
                for(int i=0; i<8; i++){
                    if(base[i]!=tmp[idx2]){
                        return false;
                    }
                    idx2++;
                    if(idx2==8){
                        idx2=0;
                    }
                }
            }else if((idx2==0&&tmp[7]==6)||(idx2!=0 && tmp[idx2-1]==6)){
                for(int i=0; i<8; i++){
                    if(base[i]!=tmp[idx2]){
                        return false;
                    }
                    idx2--;
                    if(idx2==-1){
                        idx2=7;
                    }
                }
            }else{
                return false;
            }
            
        }
        return true;
    }
    
}