class Solution {
    public int maxCoins(int[] nums) {
        int dp[][]=new int[nums.length][nums.length];
        for(int g=0;g<nums.length;g++){
            for(int i=0,j=g;j<nums.length;i++,j++){
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int left=(k==i?0:dp[i][k-1]);
                    int right=(k==j?0:dp[k+1][j]);
                    int cost=nums[k] * (i==0?1:nums[i-1]) * (j==nums.length-1?1:nums[j+1]);
                    max=Math.max(max,left+right+cost);
                }
                dp[i][j]=max;
            }
        }
        return dp[0][nums.length-1];
    }
}