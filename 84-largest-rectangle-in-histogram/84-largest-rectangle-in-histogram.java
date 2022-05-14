class Solution {
    public int largestRectangleArea(int[] heights) {
        int result =Integer.MIN_VALUE;
        int[] left = nextLeftSmall(heights);
        int[] right = nextRightSmall(heights);
        for(int i=0; i<heights.length; i++){
            int height = heights[i];
            int width = right[i]-left[i]-1;
            int tmp = height*width;
            if(tmp>result){
                result = tmp;
            }
            while(i+1<heights.length && height==heights[i+1]){
                i++;
            }
        }
        return result;
    }
    
    public int[] nextLeftSmall(int[] heights){
        int[] left = new int[heights.length];
        left[0] = -1;
        for(int i=1; i<heights.length; i++){
            if(heights[i-1]<heights[i]){
                left[i] = i - 1;
            }else if(heights[i-1]>heights[i]){
                int tmp = i - 1;
                while(left[tmp]>=0 && heights[left[tmp]]>=heights[i]){
                    tmp = left[tmp];
                }
                left[i] = left[tmp];
            }else{
                left[i] = left[i-1];
            }
        }
        return left;
    }
    
    public int[] nextRightSmall(int[] heights){
        int[] right = new int[heights.length];
        right[heights.length-1] = heights.length;
        for(int i=heights.length-2; i>=0; i--){
            if(heights[i+1]<heights[i]){
                right[i] = i+1;
            }else if(heights[i+1]>heights[i]){
                int tmp = i + 1;
                while(right[tmp]<=heights.length-1 && heights[right[tmp]]>=heights[i]){
                    tmp = right[tmp];
                }
                right[i] = right[tmp];
            }else{
                right[i] = right[i+1];
            }
        }
        return right;
    }
}