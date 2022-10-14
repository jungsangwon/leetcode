class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        for(int i=0; i<img.length; i++){
            for(int j=0; j<img[i].length; j++){
                result[i][j] = getNum(img, i, j);
            }
        }
        
        return result;
    }
    
    public int getNum(int[][] img, int x, int y){
        int result = img[x][y];
        int count = 1;
        if(x-1>=0){
            result += img[x-1][y];
            count++;
            if(y-1>=0){
                result += img[x-1][y-1];
                count++;
            }
            if(y+1<img[x].length){
                result += img[x-1][y+1];
                count++;
            }
        }
        
        if(x+1<img.length){
            result += img[x+1][y];
            count++;
            if(y-1>=0){
                result += img[x+1][y-1];
                count++;
            }
            if(y+1<img[x].length){
                result += img[x+1][y+1];
                count++;
            }
        }
        if(y-1>=0){
            result += img[x][y-1];
            count++;
        }
        if(y+1<img[x].length){
            result += img[x][y+1];
            count++;
        }
        
        return result/count;
    }
}