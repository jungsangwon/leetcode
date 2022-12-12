class Solution {
    public int dominantIndex(int[] nums) {
        int[] idx = new int[2];
        if(nums[0]>nums[1]){
            idx[1] = 1;
        }else{
            idx[0] = 1;
        }
        for(int i=2; i<nums.length; i++){
            if(nums[idx[0]]<=nums[i]){
                idx[1] = idx[0];
                idx[0] = i;
            }else if(nums[idx[1]]<=nums[i]){
                idx[1] = i;
            }
        }
        if(nums[idx[0]]>=nums[idx[1]]*2){
            return idx[0];
        }else{
            return -1;
        }
    }
}