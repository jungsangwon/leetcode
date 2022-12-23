class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0; i<matrix[0].length; i++){
            if(!isToeplitz(matrix,0,i,matrix[0][i])){
                return false;
            }
        }
        for(int i=0; i<matrix.length; i++){
            if(!isToeplitz(matrix,i,0,matrix[i][0])){
                return false;
            }
        }
        return true;
    }
    
    public boolean isToeplitz(int[][] matrix, int x, int y, int num){
        while(x<matrix.length && y<matrix[x].length){
            if(matrix[x][y]!=num){
                return false;
            }
            x++;
            y++;
        }
        return true;
    }
}