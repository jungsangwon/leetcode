class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            int[] check = new int[10];
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(check[Character.getNumericValue(board[i][j])] == 0){
                        check[Character.getNumericValue(board[i][j])]++;
                    }else{
                        return false;
                    }
                } 
            }
        }
        
        for(int i=0; i<9; i++){
            int[] check = new int[10];
            for(int j=0; j<9; j++){
                if(board[j][i] != '.'){
                    if(check[Character.getNumericValue(board[j][i])] == 0){
                        check[Character.getNumericValue(board[j][i])]++;
                    }else{
                        return false;
                    }
                } 
            }
        }
        
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                int[] check = new int[10];
                for(int k=0; k<3; k++){
                    for(int n=0; n<3; n++){
                        if(board[i+k][j+n] != '.'){
                            if(check[Character.getNumericValue(board[i+k][j+n])] == 0){
                                check[Character.getNumericValue(board[i+k][j+n])]++;
                            }else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}