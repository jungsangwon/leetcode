class NumMatrix {
    int[][] matrix;
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        sum = new int[matrix.length][matrix[0].length];
        sum[0][0] = matrix[0][0];
        for(int i=1; i<matrix.length; i++){
            sum[i][0] = sum[i-1][0]+matrix[i][0];
        }
        for(int i=1; i<matrix[0].length; i++){
            sum[0][i] = sum[0][i-1]+matrix[0][i];
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=1;j<matrix[i].length; j++){
                sum[i][j] = matrix[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = sum[row2][col2];
        if(col1>0&&row1>0){
            result = result + sum[row1-1][col1-1] -sum[row2][col1-1] -sum[row1-1][col2];
        }else{
            if(col1>0){
                result -= sum[row2][col1-1];
            }
            if(row1>0){
                result -= sum[row1-1][col2];
            }
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */