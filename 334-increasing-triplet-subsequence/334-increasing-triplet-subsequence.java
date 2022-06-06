class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        boolean[] visit = new boolean[nums.length];
        int m = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<m){
                m=nums[i];
            }else{
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]<nums[j] && min>nums[j]){
                    min = nums[j];
                    if(isIncreasing(nums,j,dp,visit)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isIncreasing(int[] nums, int idx, boolean[] dp, boolean[] visit){
        if(visit[idx]){
            return dp[idx];
        }else{
            visit[idx] = true;
            for(int i=idx+1;i<nums.length; i++){
                if(nums[idx]<nums[i]){
                    dp[idx] = true;
                    return true;
                }
            }
            dp[idx] = false;
            return false;
        }
    }
}