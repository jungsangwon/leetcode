class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int count = 1;
        int max = n*n;
        int row=0;
        int col=0;
        int[][] flag = new int[n][n];
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int now = 0;
        while(count<=max){
            result[row][col] = count;
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
            count++;
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