class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] num = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                num[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }
        
        for(int i=num.length-1; i>0; i--){
            for(int j=num[0].length-1; j>0; j--){
                int tmp1 = Math.min(num[i][j-1],num[i-1][j]);
                tmp1 = Math.min(num[i][j],tmp1);
                if(tmp1!=0&&num[i-1][j-1]==1){
                    num[i-1][j-1] = tmp1+1;
                }
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(num[i][j]>max){
                    max = num[i][j];
                }
            }
        }
        
        return max * max;
    }
}