class Solution {
    public int maxRotateFunction(int[] nums) {
        int now = getRotateFunction(nums,0);
        int max = Math.max(Integer.MIN_VALUE,now);
        int sum = 0;
        for(int i=0;i<nums.length; i++){
            sum += nums[i];
        }
        for(int i=nums.length-1; i>0; i--){
            now = now+sum-(nums[i])*nums.length;
            max = Math.max(max,now);
        }
        return max;
    }
    
    public int getRotateFunction(int[] nums, int idx) {
        int result = 0;
        int now = 0;
        for(int i = idx; i<nums.length; i++){
            result += nums[i]*now;
            now++;
        }
        for(int i=0; i<idx; i++){
            result += nums[i]*now;
            now++;
        }
        return result;
    }
}