class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return minimumDeleteSum(s1.toCharArray(),s2.toCharArray(),0,0,new int[s1.length()+1][s2.length()+1]);
    }
    
    public int minimumDeleteSum(char[] s1, char[] s2, int idx1, int idx2, int[][] dp) {
        int result = 0;
        if(s1.length==idx1&&s2.length==idx2){
            return 0;
        }else if(s1.length==idx1){
            for(int i=idx2; i<s2.length;i++){
                result += s2[i];
            }
            dp[idx1][idx2] = result;
            return result;
        }else if(s2.length==idx2){
            for(int i=idx1; i<s1.length;i++){
                result += s1[i];
            }
            dp[idx1][idx2] = result;
            return result;
        }else{
            if(dp[idx1][idx2]!=0){
                return dp[idx1][idx2];
            }
            while(idx1<s1.length && idx2<s2.length){
                if(s1[idx1]==s2[idx2]){
                    idx1++;
                    idx2++;
                }else{
                    result = s1[idx1] + minimumDeleteSum(s1,s2,idx1+1,idx2,dp);
                    result = Math.min(result,s2[idx2] + minimumDeleteSum(s1,s2,idx1,idx2+1,dp));
                    dp[idx1][idx2] = result;
                    return result;
                }
            }
            result = minimumDeleteSum(s1,s2,idx1,idx2,dp);
            dp[idx1][idx2] = result;
            return result;
        }
    }
}