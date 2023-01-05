class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int n = graph.length;
        boolean[][] map = new boolean[n][n];
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                map[i][graph[i][j]] = true;
            }
        }
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTarget(map, 0, new boolean[n], path , result);
        return result;
    }
    
    public void allPathsSourceTarget(boolean[][] map, int now, boolean[] visit, List<Integer> path, List<List<Integer>> result){
        for(int i=0; i<map.length; i++){
            if(map[now][i] && !visit[i]){
                path.add(i);
                visit[i] = true;
                if(i==map.length-1){
                    result.add(new ArrayList<>(path));
                }else{
                    allPathsSourceTarget(map, i, visit, path, result);
                }
                visit[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}