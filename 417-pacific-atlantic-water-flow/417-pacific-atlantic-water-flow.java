class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic  = new boolean[m][n];
        for(int i=0; i<m; i++){
            pacificAtlantic(heights,i,n-1,atlantic);
            pacificAtlantic(heights,i,0,pacific);
        }
        for(int i=0; i<n; i++){
            pacificAtlantic(heights,m-1,i,atlantic);
            pacificAtlantic(heights,0,i,pacific);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }
    
    public void pacificAtlantic(int[][] heights, int x, int y, boolean[][] visit) {
        if(!visit[x][y]){
            visit[x][y] = true;
            if(x-1>=0 && !visit[x-1][y] && heights[x][y]<=heights[x-1][y]){
                pacificAtlantic(heights,x-1,y,visit);
            }
            if(y-1>=0 && !visit[x][y-1] && heights[x][y]<=heights[x][y-1]){
                pacificAtlantic(heights,x,y-1,visit);
            }
            if(x+1<heights.length && !visit[x+1][y] && heights[x][y]<=heights[x+1][y]){
                pacificAtlantic(heights,x+1,y,visit);
            }
            if(y+1<heights[x].length && !visit[x][y+1] && heights[x][y]<=heights[x][y+1]){
                pacificAtlantic(heights,x,y+1,visit);
            }
        }
    }
}