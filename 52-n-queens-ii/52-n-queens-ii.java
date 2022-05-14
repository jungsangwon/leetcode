class Solution {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return setQueens(board,n,n);
    }
    
    public int setQueens(int[][] board, int n, int count){
        int result = 0;
        if(count == 0){
            return 1;
        }else{
            for(int i=0; i<n; i++){
                if(board[n-count][i] == 0){
                    setQueens(board,n,n-count,i,1);
                    result += setQueens(board, n, count-1);
                    setQueens(board,n,n-count,i,-1);
                }
            }
        }
        return result;
    }
    
    public void setQueens(int[][] board, int n, int row, int col, int tmp){
        for(int i=0; i<n; i++){
            board[row][i] += tmp;
        }
        for(int i=0; i<n; i++){
            board[i][col] += tmp;
        }
        board[row][col]-=tmp;
        int trow = row;
        int tcol = col;
        while(trow>0&&tcol>0){
            board[--trow][--tcol]+=tmp;
        }
        trow = row;
        tcol = col;
        while(trow<n-1&&tcol<n-1){
            board[++trow][++tcol]+=tmp;
        }
        trow = row;
        tcol = col;
        while(trow<n-1&&tcol>0){
            board[++trow][--tcol]+=tmp;
        }
        trow = row;
        tcol = col;
        while(trow>0&&tcol<n-1){
            board[--trow][++tcol]+=tmp;
        }
    }
}