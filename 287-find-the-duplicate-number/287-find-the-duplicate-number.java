class Solution {
    public int findDuplicate(int[] nums) {
        for(int i : nums) {
            if(nums[Math.abs(i) - 1] < 0) 
                return Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }
        return 0;
    }
}