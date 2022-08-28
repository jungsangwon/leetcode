class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            Arrays.fill(result[i],Integer.MAX_VALUE);
        }
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length;j++){
                if(mat[i][j]==0){
                    getDistance(mat,i,j,result);
                }
            }
        }
        return result;
    }
    
    public void getDistance(int[][] mat, int i, int j, int[][] result){
        int min = 0;
        Queue<Position> qu = new LinkedList<>();
        Position p = new Position(i,j);
        qu.add(p);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int k=0;k<size;k++){
                Position now = qu.poll();
                int x=now.x;
                int y=now.y;
                if(result[x][y]>min){
                    result[x][y] = min;
                    if(x+1<mat.length&&mat[x+1][y]!=0&&result[x+1][y]>min+1){
                        qu.add(new Position(x+1,y));
                    }
                    if(y+1<mat[x].length&&mat[x][y+1]!=0&&result[x][y+1]>min+1){
                        qu.add(new Position(x,y+1));
                    }
                    if(x-1>=0&&mat[x-1][y]!=0&&result[x-1][y]>min+1){
                        qu.add(new Position(x-1,y));
                    }
                    if(y-1>=0&&mat[x][y-1]!=0&&result[x][y-1]>min+1){
                        qu.add(new Position(x,y-1));
                    }
                }
            }
            min++;
        }
    }
}

class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}