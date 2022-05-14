class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<Position> qu = new LinkedList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    qu.add(new Position(i,j));
                }
            }
        }
        while(!qu.isEmpty()){
            Position tmp = qu.poll();
            setZeroes(matrix,tmp.x,tmp.y);
        }
    }
    
    public void setZeroes(int[][] matrix, int x, int y){
        for(int i=0; i<x; i++){
            matrix[i][y]=0;
        }
        for(int i=0; i<y; i++){
            matrix[x][i]=0;
        }
        for(int i=x+1; i<matrix.length; i++){
            matrix[i][y]=0;
        }
        for(int i=y+1; i<matrix[0].length; i++){
            matrix[x][i]=0;
        }
    }
}

class Position{
    public int x;
    public int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}