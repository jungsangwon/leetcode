class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
    }
    
    public boolean solveSudoku(char[][] board, int x, int y){
        boolean solveYn = false;
        if(x>8){
            return true;
        }
        if(board[x][y]!='.'){
            if(y+1<9){
                solveYn = solveSudoku(board,x,y+1);
            }else{
                solveYn = solveSudoku(board,x+1,0);
            }
        }else{
            for(int i=1; i<=9; i++){
                char tmp = Character.forDigit(i,10);
                // System.out.println("x : "+x+", y : "+y+" -> "+tmp);
                if(checking(board, x, y, tmp)){
                    // System.out.println("x : "+x+", y : "+y+" -> "+i);
                    board[x][y] = tmp;
                    if(y+1<9){
                        solveYn = solveSudoku(board,x,y+1);
                    }else{
                        solveYn = solveSudoku(board,x+1,0);
                    }
                    if(solveYn){
                        break;
                    }else{
                        board[x][y] = '.';
                    }
                }
            }
        }
        return solveYn;
    }
    
    public boolean checking(char[][] board, int x, int y, char target){
        boolean result = true;
        for(int i=0; i<9; i++){
            if(board[x][i] == target){
                return false;
            } 
        }
        
        for(int i=0; i<9; i++){
            if(board[i][y] == target){
                return false;
            } 
        }
        
        int i = (x/3)*3;
        int j = (y/3)*3;
        for(int k=0; k<3; k++){
            for(int n=0; n<3; n++){
                if(board[i+k][j+n] == target){
                    return false;
                } 
            }
        }
        
        return result;
    }
}