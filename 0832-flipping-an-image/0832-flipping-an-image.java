class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0; i<image.length; i++){
            int[] tmp = new int[image[i].length];
            for(int j=0; j<image[i].length; j++){
                tmp[j] = image[i][image[i].length-1-j]==0?1:0;
            }
            image[i] = tmp;
        }
        return image;
    }
}