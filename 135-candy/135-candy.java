class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        
        left[0] = 1;
        for(int i=1; i<left.length; i++){
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
        }
        right[right.length-1] = 1;
        for(int i=right.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                right[i] = right[i+1]+1;
            }else{
                right[i] = 1;
            }
        }
        for(int i=0;i<left.length; i++){
            result += Math.max(left[i],right[i]);
        }
        
        return result;
    }
}