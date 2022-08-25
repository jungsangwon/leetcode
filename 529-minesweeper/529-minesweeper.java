class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y] =='M'){
            board[x][y] = 'X';
        }else if(board[x][y]=='E'){
            click(board,x,y);
        }
        return board;
    }
    
    public void click(char[][] board, int x, int y){
        if(board[x][y]=='E'||board[x][y]=='M'){
            int num = getNum(board,x,y);
            if(num==0){
                board[x][y] = 'B';
                if(x+1<board.length){
                    if(y+1<board[x].length){
                        click(board,x+1,y+1);
                    }
                    if(y-1>=0){
                        click(board,x+1,y-1);
                    }
                    click(board,x+1,y);
                }
                if(x-1>=0){
                    if(y+1<board[x].length){
                        click(board,x-1,y+1);
                    }
                    if(y-1>=0){
                        click(board,x-1,y-1);
                    }
                    click(board,x-1,y);
                }
                if(y+1<board[x].length){
                    click(board,x,y+1);
                }
                if(y-1>=0){
                    click(board,x,y-1);
                }
            }else{
                board[x][y] = (char)(num+'0');
            }
        }
    }
    
    public int getNum(char[][] board, int x, int y){
        int result = 0;
        if(x+1<board.length){
            if(y+1<board[x].length){
                if(board[x+1][y+1]=='M'||board[x+1][y+1]=='X'){
                    result++;
                }
            }
            if(y-1>=0){
                if(board[x+1][y-1]=='M'||board[x+1][y-1]=='X'){
                    result++;
                }
            }
            if(board[x+1][y]=='M'||board[x+1][y]=='X'){
                result++;
            }
        }
        if(x-1>=0){
            if(y+1<board[x].length){
                if(board[x-1][y+1]=='M'||board[x-1][y+1]=='X'){
                    result++;
                }
            }
            if(y-1>=0){
                if(board[x-1][y-1]=='M'||board[x-1][y-1]=='X'){
                    result++;
                }
            }
            if(board[x-1][y]=='M'||board[x-1][y]=='X'){
                result++;
            }
        }
        if(y+1<board[x].length){
            if(board[x][y+1]=='M'||board[x][y+1]=='X'){
                result++;
            }
        }
        if(y-1>=0){
            if(board[x][y-1]=='M'||board[x][y-1]=='X'){
                result++;
            }
        }
        return result;
    }
}