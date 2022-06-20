class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return combinationSum4(nums,target,dp);
    }
    
    public int combinationSum4(int[] nums, int target, int[] dp){
        if(dp[target]!=-1){
            return dp[target];
        }
        int result = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<target){
                result += combinationSum4(nums,target-nums[i],dp);
            }else if(nums[i]==target){
                result++;
            }else{
                break;
            }
        }
        dp[target] = result;
        return result;
    }
}