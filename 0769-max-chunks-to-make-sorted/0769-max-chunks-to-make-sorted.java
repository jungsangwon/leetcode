class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int[] min = new int[arr.length];
        min[arr.length-1] = Integer.MAX_VALUE;
        
        for(int i=arr.length-2; i>=0; i--){
            min[i] = Math.min(min[i+1],arr[i+1]);
        }
        
        int max = 0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max,arr[i]);
            if(max<=min[i]){
                result++;
                max=0;
            }
        }
        return result;
    }
}