class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        return search(nums,target,left,right);
    }
    
    public boolean search(int[] nums, int target, int left, int right){
        boolean result = false;
        
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[left]<nums[right]){
                if(nums[mid]==target){
                    return true;
                }else if(nums[mid]<target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else if((nums[left]>nums[right])){
                if(nums[mid]==target){
                    return true;
                }else if(nums[mid]>nums[right]&&(nums[mid]<target || target<=nums[right])){
                    left = mid + 1;
                }else if(nums[mid]<nums[right]&&(nums[mid]<target && target<=nums[right])){
                    left = mid + 1;
                }else if(nums[mid]<nums[right]&&(nums[mid]>target || target>=nums[left])){
                    right = mid - 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(nums[mid]==nums[left]){
                    if(nums[mid]==target){
                        return true;
                    }else{
                        return search(nums,target,left,mid-1) || search(nums,target,mid+1,right);
                    }
                }else{
                    if(nums[mid]==target){
                        return true;
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
        }
        return result;
    }
}