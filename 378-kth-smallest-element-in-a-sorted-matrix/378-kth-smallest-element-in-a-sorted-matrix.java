class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int result = -1;
        int[] idx = new int[matrix.length];
        for(int i=0; i<k; i++){
            int min = Integer.MAX_VALUE;
            int row = -1;
            for(int j=0;j<idx.length; j++){
                if(idx[j]<0){
                    break;
                }else if(idx[j]>=matrix[j].length){
                    continue;
                }else{
                    if(min>matrix[j][idx[j]]){
                        min = matrix[j][idx[j]];
                        row = j;
                    }
                }
            }
            // System.out.println(min);
            idx[row]++;
            result = min;
        }
        return result;
    }
}