class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]&&dp[i]<=dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}