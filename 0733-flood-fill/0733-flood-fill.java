class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFill(image,new boolean[image.length][image[0].length],sr,sc,color,image[sr][sc]);
        return image;
    }
    
    public void floodFill(int[][] image, boolean[][] visit, int sr, int sc, int color, int check) {
        image[sr][sc] = color;
        visit[sr][sc] = true;
        if(sr+1<image.length && !visit[sr+1][sc] && image[sr+1][sc]==check){
            floodFill(image,visit,sr+1,sc,color,check);
        }
        if(sc+1<image[sr].length && !visit[sr][sc+1] && image[sr][sc+1]==check){
            floodFill(image,visit,sr,sc+1,color,check);
        }
        if(sr-1>=0 && !visit[sr-1][sc] && image[sr-1][sc]==check){
            floodFill(image,visit,sr-1,sc,color,check);
        }
        if(sc-1>=0 && !visit[sr][sc-1] && image[sr][sc-1]==check){
            floodFill(image,visit,sr,sc-1,color,check);
        }
    }
}