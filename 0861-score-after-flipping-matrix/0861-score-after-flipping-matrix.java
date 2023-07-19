class Solution {
    public int matrixScore(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            if(grid[i][0]==0){
                for(int j=0; j<grid[i].length; j++){
                    grid[i][j] = grid[i][j] ^ 1;
                }
            }
        }
        int check = grid.length/2;
        for(int i=0; i<grid[0].length; i++){
            int count = 0;
            for(int j=0; j<grid.length; j++){
                if(grid[j][i]==1){
                    count++;
                }
            }
            if(count<=check){
                for(int j=0; j<grid.length; j++){
                    grid[j][i] = grid[j][i] ^ 1;
                }
            }
        }
        int result = 0;
        int now = 1;
        for(int i=grid[0].length-1; i>=0; i--){
            for(int j=0; j<grid.length; j++){
                result += now*grid[j][i];
            }
            now*=2;
        }
        // for(int i=0; i<grid.length; i++){
        //     for(int j=0; j<grid[i].length; j++){
        //         System.out.print(grid[i][j]);
        //     }
        //     System.out.println("");
        // }
        
        return result;
    }
}