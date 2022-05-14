class Solution {
    public void rotate(int[][] matrix) {
        int idx1 = 0;
        int idx2 = matrix.length;
        while(idx1<idx2){
             rotate(matrix, idx1++, idx2--);
        }
    }
    
    public void rotate(int[][] matrix, int num1, int num2){
        int[] tmp = new int[num2-num1];
        int idx = 0;
        for(int i=num1; i<num2; i++){
            tmp[idx] = matrix[num1][i];
            matrix[num1][i] = matrix[num2-1-idx++][num1];
        }
        for(int i=num1; i<num2; i++){
            matrix[i][num1] = matrix[num2-1][i];
        }
        idx = 0;
        for(int i=num1; i<num2; i++){
            matrix[num2-1][i] = matrix[num2-1-idx++][num2-1];
        }
        idx = 0;
        for(int i=num1; i<num2; i++){
            matrix[i][num2-1] = tmp[idx++];
        }
    }
}