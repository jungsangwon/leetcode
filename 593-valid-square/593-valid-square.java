class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean result = true;
        int[][] square = new int[4][2];
        square[0] = p1;
        square[1] = p2;
        square[2] = p3;
        square[3] = p4;
        Arrays.sort(square,(int[] a, int[] b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        if(square[0][0]==square[1][0]&&square[0][1]==square[1][1]){
            return false;
        }
        int a = square[0][0];
        int b = square[0][1];
        for(int i=0;i<4;i++){
            square[i][0] -= a;
            square[i][1] -= b;
        }
        if(square[1][1]<0){
            if(square[1][0]!=square[2][1]||square[1][1]!=-square[2][0]){
                return false;
            }
            a=square[1][0];
            b=square[1][1];
            for(int i=0; i<4; i++){
                square[i][0] -= a;
                square[i][1] -= b;
            }
            if(square[3][0]!=square[0][1]||square[3][1]!=-square[0][0]){
                return false;
            }
        }else{
            if(square[2][0]!=square[1][1]||square[2][1]!=-square[1][0]){
                return false;
            }
            a=square[2][0];
            b=square[2][1];
            for(int i=0; i<4; i++){
                square[i][0] -= a;
                square[i][1] -= b;
            }
            if(square[3][0]!=square[0][1]||square[3][1]!=-square[0][0]){
                return false;
            }
        }
        return true;
    }
}