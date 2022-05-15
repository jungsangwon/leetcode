class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = 0;
        int direction = 1;
        while(true){
            // System.out.println(x+", "+y+" -> "+direction);
            if(x>=matrix.length||y>=matrix[0].length||y<0){
                return false;
            }
            if(matrix[x][y]==target){
                return true;
            }else if((direction==-1&&matrix[x][y]<target)||(direction==1&&matrix[x][y]>target)){
                x++;
                if(x>=matrix.length){
                    return false;
                }
                if(matrix[x][y]>target){
                    direction = -1;
                }else{
                    direction = 1;
                }
            }else{
                y+=direction;
                if(y==matrix[0].length){
                    y-=direction;
                    direction *=-1;
                    while(x<matrix.length && matrix[x][y]<target){
                        x++;
                    }
                }
            }
        }
    }
}