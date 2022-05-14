class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        char[] tmp = new char[n];
        for(int i=0; i<n; i++){
            tmp[i] = '.';
        }
        setQueens(board,n,n,new ArrayList<>(),result,tmp);
        return result;
    }
    
    public void setQueens(int[][] board, int n, int count, List<String> now, List<List<String>> result, char[] tmp){
        if(count == 0){
            result.add(new ArrayList<>(now));
        }else{
            for(int i=0; i<n; i++){
                if(board[n-count][i] == 0){
                    tmp[i] = 'Q';
                    now.add(String.valueOf(tmp));
                    tmp[i] = '.';
                    setQueens(board,n,n-count,i,1);
                    setQueens(board, n, count-1, now, result,tmp);
                    setQueens(board,n,n-count,i,-1);
                    now.remove(now.size()-1);
                }
            }
        }
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