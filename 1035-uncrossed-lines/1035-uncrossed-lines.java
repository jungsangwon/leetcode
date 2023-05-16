class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        return maxUncrossedLines(nums1,nums2,0,0,dp);
    }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2, int idx1, int idx2, int[][] dp){
        if(nums1.length==idx1 || nums2.length==idx2){
            return 0;
        }
        if(dp[idx1][idx2]!=0){
            return dp[idx1][idx2];
        }
        if(nums1[idx1] == nums2[idx2]){
            int result = 1 + maxUncrossedLines(nums1,nums2,idx1+1,idx2+1,dp);
            dp[idx1][idx2] = result;
            return result;
        }else{
            int result = 0;
            for(int i=idx1+1 ; i<nums1.length; i++){
                if(nums1[i] == nums2[idx2]){
                    result = Math.max(result,1+maxUncrossedLines(nums1,nums2,i+1,idx2+1,dp));
                    break;
                }
            }
            for(int i=idx2+1 ; i<nums2.length; i++){
                if(nums1[idx1] == nums2[i]){
                    result = Math.max(result,1+maxUncrossedLines(nums1,nums2,idx1+1,i+1,dp));
                    break;
                }
            }
            result = Math.max(result,maxUncrossedLines(nums1,nums2,idx1+1,idx2+1,dp));
            dp[idx1][idx2] = result;
            return result;
        }
    }
}