class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visit = new boolean[isConnected.length];
        int result = 0;
        for(int i=0; i<visit.length; i++){
            if(visit[i]){
                continue;
            }else{
                result++;
                visit(isConnected,i,visit);
            }
        }
        return result;
    }
    
    public void visit(int[][] isConnected, int idx, boolean[] visit){
        for(int i=0 ; i<isConnected.length; i++){
            if(!visit[i] && isConnected[idx][i]==1){
                visit[i] = true;
                visit(isConnected,i,visit);
            }
        }
    }
}