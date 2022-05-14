class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[left]<nums[right]){
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>nums[right]&&(nums[mid]<target || target<=nums[right])){
                    left = mid + 1;
                }else if(nums[mid]<nums[right]&&(nums[mid]<target && target<=nums[right])){
                    left = mid + 1;
                }else if(nums[mid]<nums[right]&&(nums[mid]>target || target>=nums[left])){
                    right = mid - 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return result;
    }
}