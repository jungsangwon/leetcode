class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        boolean[] visit = new boolean[graph.length];
        boolean[] isSafe = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(isSafe(graph,visit,isSafe,i)){
                result.add(i);
            }
        }
        
        return result;
    }
    
    public boolean isSafe(int[][] graph, boolean[] visit, boolean[] isSafe, int idx){
        if(visit[idx]){
            return isSafe[idx];
        }else{
            visit[idx] = true;
            boolean tmp = true;
            for(int i=0; i<graph[idx].length; i++){
                tmp = tmp && isSafe(graph,visit,isSafe,graph[idx][i]);
            }
            isSafe[idx] = tmp;
            return tmp;
        }
    }
}