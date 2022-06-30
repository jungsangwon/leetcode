class Solution {
    private class Pair implements Comparable<Pair>{
        int row;
        int col;
        int height;
        Pair(int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }
        @Override
        public int compareTo(Pair p){
            return this.height - p.height;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean [][] vis = new boolean[m][n];
        
        for(int i = 0;  i < heightMap.length; i++){
            for(int j = 0; j < heightMap[i].length; j++){
                if(i == 0 || i == heightMap.length - 1 || j == 0 || j == heightMap[i].length - 1){
                    pq.add(new Pair(i, j, heightMap[i][j]));
                    vis[i][j] = true;
                }
            }
        }
        
        int [][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; 
        int water = 0;
        
        while(pq.size() > 0){
            Pair pair = pq.remove();
            int val = heightMap[pair.row][pair.col];
            for(int k = 0; k < 4; k++){
                int ni = pair.row + dirs[k][0];
                int nj = pair.col + dirs[k][1];
                
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && vis[ni][nj] == false){
                    if(heightMap[ni][nj] < val){
                        water += (val - heightMap[ni][nj]);
                        heightMap[ni][nj] = val;
                    }
                    pq.add(new Pair(ni, nj, heightMap[ni][nj]));
                    vis[ni][nj] = true;
                }
            }
        }
        return water;
    }
}