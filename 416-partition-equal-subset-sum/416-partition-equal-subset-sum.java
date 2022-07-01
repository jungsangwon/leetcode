class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return false;
        }else{
            int[][] dp = new int[nums.length][(sum/2)+1];
            return canPartition(nums,0,0,sum/2,dp);
        }
    }
    
    public boolean canPartition(int[] nums, int idx, int group1, int sum, int[][] dp) {
        if(group1>sum){
            return false;
        }
        if(nums.length == idx){
            return group1==sum;
        }
        if(dp[idx][group1]==0){
            if(group1<sum){
                boolean result = canPartition(nums, idx+1, group1+nums[idx], sum,dp) || canPartition(nums, idx+1, group1, sum,dp);
                if(result){
                    dp[idx][group1]=1;
                }else{
                    dp[idx][group1]=-1;
                }
                return result;
            }else if(group1>sum){
                return false;
            }else{
                return true;
            }
        }
        return dp[idx][group1]==1;
    }
}