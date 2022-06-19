class Solution {
    public int wiggleMaxLength(int[] nums) {
        int result = 0;
        int dp[][] = new int[nums.length][2];
        for(int i=0; i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<nums.length;i++){
            result = Math.max(result,wiggleMaxLength(nums,i,0,dp)+1);
            result = Math.max(result,wiggleMaxLength(nums,i,1,dp)+1);
        }
        return result;
    }
    
    public int wiggleMaxLength(int[] nums, int idx, int big, int dp[][]){
        int result = 0;
        if(dp[idx][big]!=-1){
            return dp[idx][big];
        }
        if(big==0){
            for(int i=idx+1;i<nums.length; i++){
                if(nums[idx]<nums[i]){
                    result = Math.max(result,wiggleMaxLength(nums,i,1,dp)+1);
                }
            }
        }else{
            for(int i=idx+1;i<nums.length;i++){
                if(nums[idx]>nums[i]){
                    result = Math.max(result,wiggleMaxLength(nums,i,0,dp)+1);
                }
            }
        }
        dp[idx][big] = result;
        return result;
    }
}