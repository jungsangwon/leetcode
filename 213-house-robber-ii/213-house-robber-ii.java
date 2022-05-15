class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        rob(nums,0,dp,nums.length-1);
        int max1 = dp[0];
        int max2 = 0;
        Arrays.fill(dp,-1);
        rob(nums,1,dp,nums.length);
        max2 = dp[1];
        return Math.max(max1,max2);
    }
    
    public int rob(int[]nums, int now, int[] dp, int limit){
        int result = 0;
        if(now>=limit){
            return 0;
        }
        if(dp[now]!=-1){
            return dp[now];
        }else{
            result = Math.max(nums[now]+rob(nums,now+2,dp,limit),rob(nums,now+1,dp,limit));
        }
        dp[now] = result;
        return result;
    }
}