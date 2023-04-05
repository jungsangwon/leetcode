class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int result = 0;
        for(int i=0; i<img1.length; i++){
            for(int j=0; j<img1[i].length; j++){
                result = Math.max(result, largestOverlap(img1,img2,i,j));
            }
        }
        return result;
    }
    
    public int largestOverlap(int[][] img1, int[][] img2, int x, int y) {
        int result = 0;
        int[] idx1 = new int[2];
        int[] idx2 = new int[2];
        idx1[0] = x;
        idx1[1] = y;
        result = largestOverlap(img1,img2,idx1,idx2);
        idx1 = new int[2];
        idx2[0] = img2.length-1-x;
        idx2[1] = img2[0].length-1-y;
        result = Math.max(result,largestOverlap(img1,img2,idx1,idx2));
        idx1[0] = 0;
        idx1[1] = img1[0].length-1-y;
        idx2[0] = img2.length-1-x;
        idx2[1] = 0;
        result = Math.max(result,largestOverlap(img1,img2,idx1,idx2));
        idx1[0] = img1.length-1-x;
        idx1[1] = 0;
        idx2[0] = 0;
        idx2[1] = img2[0].length-1-y;
        result = Math.max(result,largestOverlap(img1,img2,idx1,idx2));
        return result;
    }
    
    public int largestOverlap(int[][] img1, int[][] img2, int[] idx1, int[] idx2){
        int result = 0;
        int tmp1;
        int tmp2;
        while(idx1[0] <img1.length && idx2[0] < img2.length){
            tmp1 = idx1[1];
            tmp2 = idx2[1];
            while(tmp1<img1[idx1[0]].length && tmp2<img2[idx2[0]].length){
                if(img1[idx1[0]][tmp1] == 1 && img1[idx1[0]][tmp1] == img2[idx2[0]][tmp2]){
                    result++;
                }
                tmp1++;
                tmp2++;
            }
            idx1[0]++;
            idx2[0]++;
        }
        return result;
    }
}