class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            if(nums[left]!=val){
                left++;
                count++;
            }else{
                if(nums[right]!=val){
                    nums[left] = nums[right];
                    right--;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
}