class Solution {
    public int minMoves(int[] nums) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            nums[i] = nums[i] - min;
        }
        
        for (int num : nums) {
            result = result + num;
        }
        return result;
    }
}