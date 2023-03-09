class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int[] count = new int[2];
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                count[board[i][j]]++;
                x[j]+=board[i][j];
                y[i]+=board[i][j];
            }
        }
        int first = 0;
        if(n%2==0){
            if(count[0]!=count[1]){
                return -1;
            }
            first=board[0][0];
            int tmp = n/2;
            for(int i=0; i<n; i++){
                if(x[i]!=tmp || y[i]!=tmp){
                    return -1;
                }
            }
           
            int result = Integer.MAX_VALUE;
            for(int i=0; i<=1; i++){
                for(int j=0; j<=1; j++){
                    int[][] next = new int[n][n];
                    for(int k=0; k<n; k++){
                        next[k] = board[k].clone();
                    }
                    int now = getCount(next,i,j);
                    if(now!=-1){
                        result = Math.min(result,now);
                    }
                }
            }
            if(result == Integer.MAX_VALUE){
                return -1;
            }else{
                return result;
            }
        }else{
            if(Math.abs(count[0]-count[1])!=1){
                return -1;
            }
            if(count[0]<count[1]){
                first = 1;
            }
            int tmp = n/2;
            for(int i=0; i<n; i++){
                if(x[i]<tmp || x[i]>tmp+1 || y[i]<tmp || y[i]>tmp+1){
                    return -1;
                }
            }
            int sum = reorder(board,x,y,first);
            // System.out.println(sum);
            // for(int i=0; i<board.length; i++){
            //     for(int j=0; j<board.length; j++){
            //         System.out.print(board[i][j]+" ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("=============");
            int cnt = getCount(board,first,first);
            if(cnt==-1){
                return -1;
            }else{
                return sum+cnt;
            }
        }
    }
    
    public int reorder(int[][] board, int[] x, int[] y, int first){
        int count = 0;
        int tmp = board.length/2+first;
        int check = first==1?-1:1;
        for(int i=0 ;i<y.length; i++){
            if(y[i]!=tmp){
                count++;
                for(int j=i+1;j<y.length; j+=2){
                    if(y[j]==tmp){
                        int[] t = board[i];
                        board[i] = board[j];
                        board[j] = t;
                        int k = y[i];
                        y[i] = y[j];
                        y[j] = k;
                        break;
                    }
                }
            }
            tmp+=check;
            check*=-1;
        }
        tmp = board.length/2+first;
        check = first==1?-1:1;
        for(int i=0 ;i<x.length; i++){
            if(x[i]!=tmp){
                count++;
                for(int j=i+1;j<x.length; j+=2){
                    if(x[j]==tmp){
                        for(int m =0; m<board.length; m++){
                            int k = board[m][j];
                            board[m][j] = board[m][i];
                            board[m][i] = k;
                        }
                        int k = x[i];
                        x[i] = x[j];
                        x[j] = k;
                        break;
                    }
                }
            }
            tmp+=check;
            check*=-1;
        }
        return count;
    }
    
    public int getCount(int[][] next, int x, int y){
        // System.out.println(x+" ~ "+y);
        int count2 = 0;
        int now = x;
        int[][] board = new int[next.length][next.length];
        for(int i=0; i<next.length; i++){
            board[i] = next[i].clone();
        }
        for(int i=0; i<board.length; i++){
            if(board[i][0] != now){
                count2++;
                for(int j=i+1;j<board.length;j+=2){
                    if(board[j][0]==now){
                        int[] tmp = board[i];
                        board[i] = board[j];
                        board[j] = tmp;
                        break;
                    }
                }
            }
            now = now == 0?1:0;
        }
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<board.length; j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("=============");
        now = y;
        for(int i=0; i<board.length; i++){
            if(board[0][i] != now){
                count2++;
                for(int j=i+1;j<board.length;j+=2){
                    if(board[0][j]==now){
                        for(int k =0; k<board.length; k++){
                            int tmp = board[k][j];
                            board[k][j] = board[k][i];
                            board[k][i] = tmp;
                        }
                        break;
                    }
                }
            }
            now = now == 0?1:0;
        }
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<board.length; j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("=============");
        
        if(!isChessBoard(board)){
            count2 = -1;
        }
        for(int i=0; i<next.length; i++){
            board[i] = next[i].clone();
        }
        int count1=0;
        now = x;
        for(int i=0; i<board.length; i++){
            if(board[0][i] != now){
                count1++;
                for(int j=i+1;j<board.length;j+=2){
                    if(board[0][j]==now){
                        for(int k =0; k<board.length; k++){
                            int tmp = board[k][j];
                            board[k][j] = board[k][i];
                            board[k][i] = tmp;
                        }
                        break;
                    }
                }
            }
            now = now == 0?1:0;
        }
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<board.length; j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("=============");
        now = y;
        for(int i=0; i<board.length; i++){
            if(board[i][0] != now){
                count1++;
                for(int j=i+1;j<board.length;j+=2){
                    if(board[j][0]==now){
                        int[] tmp = board[i];
                        board[i] = board[j];
                        board[j] = tmp;
                        break;
                    }
                }
            }
            now = now == 0?1:0;
        }
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<board.length; j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("=============");
        
        if(isChessBoard(board)){
            if(count2==-1){
                return count1;
            }
            return Math.min(count1,count2);
        }
        return count2;
    }
    
    public boolean isChessBoard(int[][] board){
        int before = board[0][0]==0?1:0;
        for(int i=0; i<board.length; i++){
            if(before == board[i][0]){
                return false;
            }
            before = board[i][0];
            int tmp = before;
            for(int j=1; j<board[i].length; j++){
                if(tmp == board[i][j]){
                    return false;
                }
                tmp = board[i][j];
            }
        }
        return true;
    }
}