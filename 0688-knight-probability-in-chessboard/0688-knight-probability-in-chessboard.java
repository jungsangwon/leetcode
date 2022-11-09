class Solution {
    HashMap<String,Double> dp = new HashMap<>();
    int[] moveRow = {-1,-2,-2,-1,1,2,2,1};
    int[] moveColumn = {-2,-1,1,2,2,1,-1,-2};
    public double knightProbability(int n, int k, int row, int column) {
        if(row<0||row>=n||column<0||column>=n){
            return 0D;
        }else if(k==0){
            return 1D;
        }
        String key = row+","+column+","+k;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        double result = 0D;
        for(int i=0; i<8; i++){
            result += knightProbability(n,k-1,row+moveRow[i],column+moveColumn[i])/8;
        }
        dp.put(key,result);
        return result;
    }
}
