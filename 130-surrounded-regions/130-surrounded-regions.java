class Solution {
    public void solve(char[][] board) {
        int[][] check = new int[board.length][board[0].length];
        checking(board,check);
        for(int i=0;i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='O' && check[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void checking(char[][] board, int[][] check){
        for(int i=0;i<board[0].length;i++){
            if(board[0][i] == 'O' && check[0][i]==0){
                checking(board,check,0,i);
            }
        }
        for(int i=1;i<board.length;i++){
            if(board[i][0] == 'O' && check[i][0]==0){
                checking(board,check,i,0);
            }
        }
        int len = board[0].length-1;
        for(int i=1;i<board.length;i++){
            if(board[i][len] == 'O' && check[i][len]==0){
                checking(board,check,i,len);
            }
        }
        len = board.length-1;
        for(int i=1;i<board[0].length;i++){
            if(board[len][i] == 'O' && check[len][i]==0){
                checking(board,check,len,i);
            }
        }
    }
    
    public void checking(char[][] board, int[][] check, int x, int y){
        check[x][y] = 1;
        if(x-1>=0 && board[x-1][y] =='O' && check[x-1][y]==0){
            checking(board,check,x-1,y);
        }
        if(y-1>=0 && board[x][y-1] =='O' && check[x][y-1]==0){
            checking(board,check,x,y-1);
        }
        if(x+1<board.length && board[x+1][y] =='O' && check[x+1][y]==0){
            checking(board,check,x+1,y);
        }
        if(y+1<board[0].length && board[x][y+1] =='O' && check[x][y+1]==0){
            checking(board,check,x,y+1);
        }
    }
}