class Solution {
    public int trap(int[] height) {
        int result = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = 0;
        for(int i=0; i<height.length-1; i++){
            if(max<height[i]){
                max = height[i];
            }
            left[i+1] = max;
        }
        
        max = 0;
        for(int i=height.length-1; i>0; i--){
            if(max<height[i]){
                max = height[i];
            }
            right[i-1] = max;
        }
        // for(int i=0; i<height.length; i++){
        //     System.out.print(left[i]+ " ");
        // }
        // System.out.println("");
        // for(int i=0; i<height.length; i++){
        //     System.out.print(right[i]+ " ");
        // }
        // System.out.println("");
        
        for(int i=1; i<height.length-1; i++){
            int min = left[i] > right[i] ? right[i] : left[i];
            if(min>height[i]){
                result += (min-height[i]);
            }
        }
        return result;
    }
}