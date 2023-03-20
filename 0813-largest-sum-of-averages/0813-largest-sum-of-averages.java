class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[nums.length][k+1];
        
        largestSumOfAverages(nums,k,0,dp);
        
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[i].length; j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        
        return dp[0][k];
    }
    
    public double largestSumOfAverages(int[] nums, int k, int idx, double[][] dp){
        double result = 0D;
        if(k==1){
            for(int i=idx; i<nums.length; i++){
                result += nums[i];
            }
            result /= (nums.length-idx);
            dp[idx][k] = result;
            return result;
        }
        if(dp[idx][k]!=0){
            return dp[idx][k];
        }
        int sum = 0;
        int count = 0;
        for(int i=idx; i<=nums.length-k; i++){
            sum+=nums[i];
            count++;
            result = Math.max(result,(double)sum/count + largestSumOfAverages(nums,k-1,i+1,dp));
        }
        dp[idx][k] = result;
        return result;
    }
}
