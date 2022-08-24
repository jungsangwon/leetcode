class Solution {
    public int countArrangement(int n) {
        boolean[][] beautiful =new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if((i+1)%(j+1)==0 || (j+1)%(i+1)==0){
                    beautiful[i][j] = true;
                    beautiful[j][i] = true;
                }
            }
        }
        return countArrangement(new boolean[n],0,beautiful);
    }
    
    public int countArrangement(boolean[] check, int idx, boolean[][] beautiful){
        int result = 0;
        if(check.length==idx){
            return 1;
        }
        for(int i=0; i<check.length; i++){
            if(!check[i] && beautiful[idx][i]){
                check[i] = true;
                result += countArrangement(check,idx+1,beautiful);
                check[i] = false;
            }
        }
        return result;
    }
}