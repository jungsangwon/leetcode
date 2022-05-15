class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        rob(nums,0,dp);
        return dp[0];
    }
    
    public int rob(int[]nums, int now, int[] dp){
        int result = 0;
        if(now>=nums.length){
            return 0;
        }
        if(dp[now]!=-1){
            return dp[now];
        }else{
            result = Math.max(nums[now]+rob(nums,now+2,dp),rob(nums,now+1,dp));
        }
        dp[now] = result;
        return result;
    }
}