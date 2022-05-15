class Solution {
    public void gameOfLife(int[][] board) {
        int[][] next = new int[board.length][board[0].length];
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                next[i][j] = getNext(board,i,j);
            }
        }
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = next[i][j];
            }
        }
    }
    
    public int getNext(int[][] board, int x, int y){
        int count = getCount(board,x,y);
        if(board[x][y]==1){
            if(count<2 || count>3){
                return 0;
            }else {
                return 1;
            }
        }else{
            if(count==3){
                return 1;
            }else{
                return 0;
            }
        }
    }
    
    public int getCount(int[][] board, int x, int y){
        int count=0;
        if(x-1>=0){
            if(y-1>=0){
                count+=board[x-1][y-1];
            }
            if(y+1<board[x].length){
                count+=board[x-1][y+1];
            }
            count+=board[x-1][y];
        }
        if(x+1<board.length){
            if(y-1>=0){
                count+=board[x+1][y-1];
            }
            if(y+1<board[x].length){
                count+=board[x+1][y+1];
            }
            count+=board[x+1][y];
        }
        if(y-1>=0){
            count+=board[x][y-1];
        }
        if(y+1<board[x].length){
            count+=board[x][y+1];
        }
        return count;
    }
}