class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            if(nums[left]<nums[right]){
                return nums[left];
            }else{
                int mid = (left + right) / 2;
                if(right-left>1 && nums[mid-1]>nums[mid] && nums[mid]<nums[mid+1]){
                    return nums[mid];
                }
                if(nums[right]<nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return nums[left];
    }
}