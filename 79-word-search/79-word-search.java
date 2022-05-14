class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordList = word.toCharArray();
        int[][] check = new int[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(wordList[0]==board[i][j]){
                    check[i][j] = 1;
                    if(exist(board,wordList,1,check,i,j)){
                        return true;
                    }
                    check[i][j] = 0;
                }
            }
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, char[] wordList, int idx, int[][] check, int x, int y){
        boolean result = false;
        if(wordList.length == idx){
            return true;
        }
        if(x-1>=0 && check[x-1][y]==0&&wordList[idx]==board[x-1][y]){
            check[x-1][y] = 1;
            result = result || exist(board,wordList,idx+1,check,x-1,y);
            check[x-1][y] = 0;
        }
        if(result){
            return true;
        }
        
        if(x+1<board.length && check[x+1][y]==0&&wordList[idx]==board[x+1][y]){
            check[x+1][y] = 1;
            result = result || exist(board,wordList,idx+1,check,x+1,y);
            check[x+1][y] = 0;
        }
        if(result){
            return true;
        }
        
        if(y-1>=0 && check[x][y-1]==0&&wordList[idx]==board[x][y-1]){
            check[x][y-1] = 1;
            result = result || exist(board,wordList,idx+1,check,x,y-1);
            check[x][y-1] = 0;
        }
        if(result){
            return true;
        }
        
        if(y+1<board[x].length && check[x][y+1]==0&&wordList[idx]==board[x][y+1]){
            check[x][y+1] = 1;
            result = result || exist(board,wordList,idx+1,check,x,y+1);
            check[x][y+1] = 0;
        }
        if(result){
            return true;
        }
        
        return false;
    }
}