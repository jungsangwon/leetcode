class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean result = false;
        int[] check = new int[graph.length];
        boolean[][] map = new boolean[graph.length][graph.length];
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                map[i][graph[i][j]] = true;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        check[0] = 1;
        int now = -1;
        while(true){
            int size = qu.size();
            for(int i=0; i<size; i++){
                int idx = qu.poll();
                for(int j=0; j<graph[idx].length; j++){
                    if(map[idx][graph[idx][j]]){
                        if(check[graph[idx][j]]==check[idx]){
                            return false;
                        }else{
                            map[idx][graph[idx][j]] = false;
                            map[graph[idx][j]][idx] = false;
                            check[graph[idx][j]] = now;
                            qu.add(graph[idx][j]);
                        }
                    }
                }
            }
            now *=-1;
            if(qu.isEmpty()){
                for(int i=0; i<check.length; i++){
                    if(check[i]==0){
                        qu.add(i);
                        check[i] = 1;
                        now = -1;
                        break;
                    }
                }
            }
            if(qu.isEmpty()){
                break;
            }
        }
        return true;
    }
}
