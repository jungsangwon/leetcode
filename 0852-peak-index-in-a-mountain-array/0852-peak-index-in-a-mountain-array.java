class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = (left+right) / 2;
            if(mid+1<arr.length){
                if(arr[mid]<arr[mid+1]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }else{
                if(arr[mid]<arr[mid-1]){
                    right = mid-1;
                }else{
                    left = mid;
                }
            }
        }
        return left;
    }
}