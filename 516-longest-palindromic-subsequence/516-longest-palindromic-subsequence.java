class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s.toCharArray(),0,s.length()-1,new int[s.length()][s.length()]);
    }
    
    public int longestPalindromeSubseq(char[] s, int left, int right, int[][] dp) {
        if(left==right){
            return 1;
        }else if(left>right){
            return 0;
        }
        if(dp[left][right]!=0){
            return dp[left][right];
        }else{
            int result = 0;
            if(s[left]==s[right]){
                result = 2 + longestPalindromeSubseq(s,left+1,right-1,dp);
            }else{
                result = Math.max(longestPalindromeSubseq(s,left+1,right,dp),longestPalindromeSubseq(s,left,right-1,dp));
            }
            dp[left][right] = result;
            return result;
        }
    }
}