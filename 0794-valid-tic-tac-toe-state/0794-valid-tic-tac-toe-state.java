class Solution {
    public boolean validTicTacToe(String[] board) {
        int[][] count = new int[2][3];
        int[] xy = new int[2];
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j)=='X'){
                    count[0][i]--;
                    count[1][j]--;
                    xy[0]++;
                }else if(board[i].charAt(j)=='O'){
                    count[0][i]++;
                    count[1][j]++;
                    xy[1]++;
                }
            }
        }
        
        int[] complete = new int[2];
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                if(count[i][j]==3){
                    complete[1]++;
                }else if(count[i][j]==-3){
                    complete[0]++;
                }
            }
        }
        
        int x_shape = 0;
        int check = 0;
        for(int i=0; i<3; i++){
            if(board[i].charAt(i)=='X'){
                check--;
            }else if(board[i].charAt(i)=='O'){
                check++;
            } 
        }
        if(check==3){
            complete[1]++;
            x_shape++;
        }else if(check==-3){
            complete[0]++;
            x_shape--;
        }
        
        check = 0;
        for(int i=0; i<3; i++){
            if(board[i].charAt(2-i)=='X'){
                check--;
            }else if(board[i].charAt(2-i)=='O'){
                check++;
            } 
        }
        if(check==3){
            complete[1]++;
            x_shape++;
        }else if(check==-3){
            complete[0]++;
            x_shape--;
        }
        
        if(complete[0]!=0&&complete[1]!=0){
            return false;
        }else if(complete[0]==1){
            if(xy[0]==xy[1]+1){
                return true;
            }else{
                return false;
            }
        }else if(complete[1]==1){
            if(xy[0]==xy[1]){
                return true;
            }else{
                return false;
            }
        }else if(complete[0]==2){
            if(xy[0]==xy[1]+1){
                return true;
            }else{
                return false;
            }
        }else if(complete[1]==2){
            if(xy[0]==xy[1]){
                return true;
            }else{
                return false;
            }
        }else if(complete[0]==0 && complete[1]==0){
            if(xy[0]>=xy[1] && xy[0]<=xy[1]+1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}