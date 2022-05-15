class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right =nums.length-1;
        if(left == right){
            return left;
        }
        if(nums[left]>nums[left+1]){
            return left;
        }
        if(nums[right]>nums[right-1]){
            return right;
        }
        while(left<=right){
            int mid = (left+right) /2;
            // System.out.println(left +" -> "+right+" = "+mid);
            if((mid-1<0 || nums[mid]>nums[mid-1])&&(mid+1>=nums.length || nums[mid]>nums[mid+1])){
                return mid;
            }else if((mid-1<0 || nums[mid]>nums[mid-1])&&(mid+1>=nums.length || nums[mid]<nums[mid+1])){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return left;
    }
}