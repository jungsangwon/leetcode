class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length!=0){
            int count = matrix.length * matrix[0].length;
            int row=0;
            int col=0;
            int[][] flag = new int[matrix.length][matrix[0].length];
            int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
            int now = 0;
            while(count>0){
                result.add(matrix[row][col]);
                flag[row][col]=1;
                for(int i=0; i<4; i++){
                    int nextRow = row+direction[now][0];
                    int nextCol = col+direction[now][1];
                    if(check(flag,nextRow,nextCol)){
                        row = nextRow;
                        col = nextCol;
                        break;
                    }else{
                        now++;
                        if(now==4){
                            now=0;
                        }
                    }
                }
                count--;
            }
        }
        return result;
    }
    
    public boolean check(int[][] flag, int nextRow, int nextCol){
        if(nextRow<0 || nextRow>=flag.length || nextCol<0 || nextCol>=flag[0].length || flag[nextRow][nextCol] !=0 ){
            return false;
        }else{
            return true;
        }
    }
}