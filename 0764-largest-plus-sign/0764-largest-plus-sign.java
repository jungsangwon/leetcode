class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] map = new int[n][n];
        for(int i=0; i<mines.length; i++){
            map[mines[i][0]][mines[i][1]] = 1;
        }
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<n; j++){
                if(map[j][i]==0){
                    max++;
                }else{
                    max=0;
                }
                up[j][i] = max;
            }
        }
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=n-1; j>=0; j--){
                if(map[j][i]==0){
                    max++;
                }else{
                    max=0;
                }
                down[j][i] = max;
            }
        }
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<n; j++){
                if(map[i][j]==0){
                    max++;
                }else{
                    max=0;
                }
                left[i][j] = max;
            }
        }
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=n-1; j>=0; j--){
                if(map[i][j]==0){
                    max++;
                }else{
                    max=0;
                }
                right[i][j] = max;
            }
        }
        int result = 0;
        int[] bound = new int[2];
        int len = (n-1)/2;
        bound[0] = len;
        bound[1] = n-len-1;
        for(int i=len; i>=0; i--){
            for(int j=bound[0]; j<=bound[1]; j++){
                for(int k=bound[0]; k<=bound[1]; k++){
                    int tmp = up[j][k];
                    tmp = Math.min(tmp,down[j][k]);
                    tmp = Math.min(tmp,left[j][k]);
                    tmp = Math.min(tmp,right[j][k]);
                    result = Math.max(tmp,result);
                    if(i+1==result){
                        return result;
                    }
                }
            }
            bound[0]--;
            bound[1]++;
        }
        return result;
    }
}
