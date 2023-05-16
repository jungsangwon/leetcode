class Solution {
    public int longestMountain(int[] arr) {
        int result = 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int max = arr.length-1;
        for(int i=1;i<max; i++){
            if(arr[i]>arr[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        
        for(int i=max-1;i>=0; i--){
            if(arr[i+1]<arr[i]){
                right[i] = right[i+1]+1;
            }
        }
        for(int i=1; i<max; i++){
            // System.out.println(i+" : "+left[i]+ ", "+right[i]);
            if(left[i]!=0 && right[i]!=0){
                result = Math.max(result,left[i]+right[i]+1);
            }
        }
        return result;
    }
}