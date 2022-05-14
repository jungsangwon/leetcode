class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int idx = 0;
        int left =0;
        int right = matrix.length -1;
        int mid=-1;
        while(left<=right){
            mid = (left + right) / 2;
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        idx = right;
        if(right<0){
            idx = 0;
        }
        left = 0;
        right = matrix[idx].length - 1;
        while(left<=right){
            mid = (left + right) / 2;
            if(matrix[idx][mid]==target){
                return true;
            }else if(matrix[idx][mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return false;
    }
}