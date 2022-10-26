class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int result = 1;
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                count++;
            }else{
                result = Math.max(count,result);
                count=1;
            }
        }
        result = Math.max(count,result);
        return result;
    }
}