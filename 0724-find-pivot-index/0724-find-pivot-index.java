class Solution {
    public int pivotIndex(int[] nums) {
        int leftsum = 0;
        int rightsum = 0;
        int result = -1;
        for(int i=0;i<nums.length; i++){
            rightsum += nums[i];
        }
        for(int i=0; i<nums.length; i++){
            rightsum -= nums[i];
            if(leftsum == rightsum){
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}