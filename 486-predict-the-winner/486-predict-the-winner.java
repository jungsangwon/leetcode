class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        int max = PredictTheWinner(nums,0,nums.length-1,dp);
        return max>=(sum-max);
    }
    
    public int PredictTheWinner(int[] nums, int left, int right, int[][] dp) {
        if(left==right){
            dp[left][right] = nums[left];
            return nums[left];
        }else if(left>right){
            return 0;
        }
        if(dp[left][right]!=0){
            return dp[left][right];
        }
        int leftSum = nums[left] + Math.min(PredictTheWinner(nums,left+2,right,dp),PredictTheWinner(nums,left+1,right-1,dp));
        int rightSum = nums[right] + Math.min(PredictTheWinner(nums,left,right-2,dp),PredictTheWinner(nums,left+1,right-1,dp));
        dp[left][right] = Math.max(leftSum,rightSum);
        return dp[left][right];
    }
}