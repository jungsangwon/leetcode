class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[idx++] = nums[i];
            }
        }
        
        for(int i=nums.length-1;i>=idx;i--){
            nums[i] = 0;
        }
    }
}