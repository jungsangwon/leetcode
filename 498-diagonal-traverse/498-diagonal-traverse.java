class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length*mat[0].length];
        boolean up = true;
        int x = 0;
        int y = 0;
        for(int i=0; i<result.length; i++){
            // System.out.println(x+", "+y);
            result[i] = mat[x][y];
            if(up){
                if(x-1>=0 && y+1<mat[0].length){
                    x--;
                    y++;
                }else{
                    if(y+1<mat[0].length){
                        y++;
                    }else{
                        x++;
                    }
                    up = !up;
                }
            }else{
                if(x+1<mat.length && y-1>=0){
                    x++;
                    y--;
                }else{
                    if(x+1<mat.length){
                        x++;
                    }else{
                        y++;
                    }
                    up = !up;
                }
            }
        }
        
        return result;
    }
}