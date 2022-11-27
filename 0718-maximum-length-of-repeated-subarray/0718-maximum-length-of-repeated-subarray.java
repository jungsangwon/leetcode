class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        int idx1 = nums1.length-1;
        int idx2 = nums2.length-1;
        while(idx1>=0 && idx2>=0){
            for(int i=idx1; i<nums1.length; i++){
                if(nums1[i]==nums2[idx2]){
                    if(i==nums1.length-1 || idx2==nums2.length-1){
                        dp[i][idx2] = Math.max(dp[i][idx2],1);
                    }else{
                        dp[i][idx2] = Math.max(dp[i][idx2],dp[i+1][idx2+1]+1);
                    }
                }
                result = Math.max(result,dp[i][idx2]);
            }
            for(int i=idx2; i<nums2.length; i++){
                if(nums1[idx1]==nums2[i]){
                    if(idx1==nums1.length-1 || i==nums2.length-1){
                        dp[idx1][i] = Math.max(dp[idx1][i],1);
                    }else{
                        dp[idx1][i] = Math.max(dp[idx1][i],dp[idx1+1][i+1]+1);
                    }
                }
                result = Math.max(result,dp[idx1][i]);
            }
            idx1--;
            idx2--;
        }
        return result;
    }
}