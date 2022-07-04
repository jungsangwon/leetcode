class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        boolean[][] visit = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(!visit[i][j] && board[i][j] == 'X'){
                    count++;
                    int next = j+1;
                    while(next<board[i].length){
                        if(board[i][next]=='X'){
                            visit[i][next++] = true;
                        }else{
                            break;
                        }
                    }
                    next = i+1;
                    while(next<board.length){
                        if(board[next][j]=='X'){
                            visit[next++][j] = true;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}