class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            if(nums[left]<nums[right] || left == right){
                return nums[left];
            }else{
                int mid = (left + right) / 2;
                if(nums[mid]>nums[right]){
                    left = mid + 1;
                }else if(nums[mid]<nums[left]){
                    right = mid;
                }else if(nums[mid]==nums[left]&& nums[mid]==nums[right]){
                    left++;
                    right--;
                }
            }
        }
        return nums[left];
    }
}