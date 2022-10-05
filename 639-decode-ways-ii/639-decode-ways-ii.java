class Solution {
    public int numDecodings(String s) {
        return (int)numDecodings(s.toCharArray(),0,new long[s.length()]);
    }
    
    public long numDecodings(char[] s, int idx, long[] dp) {
        long mod = 1000000007;
        if(idx==s.length){
            return 1;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }else{
            long result = 0;
            if(s[idx]=='*'){
                result += numDecodings(s,idx+1,dp)*9;
                result = result % mod;
                if(idx+1<s.length){
                    if(s[idx+1]=='*'){
                        result += numDecodings(s,idx+2,dp)*15;
                    }else if(s[idx+1]<'7'){
                        result += numDecodings(s,idx+2,dp)*2;
                    }else{
                        result += numDecodings(s,idx+2,dp);
                    }
                    result = result % mod;
                }
            }else{
                if(s[idx]=='0'){
                    return 0;
                }else{
                    result += numDecodings(s,idx+1,dp);
                    result = result % mod;
                    if(idx+1<s.length){
                        if(s[idx+1]=='*'){
                            if(s[idx]=='1'){
                                result += numDecodings(s,idx+2,dp)*9;
                            }else if(s[idx]=='2'){
                                result += numDecodings(s,idx+2,dp)*6;
                            }
                        }else if(s[idx]=='1'||(s[idx]=='2'&&s[idx+1]<'7')){
                            result += numDecodings(s,idx+2,dp);
                        }
                        result = result % mod;
                    }
                }
            }
            result = result % mod;
            dp[idx] = result;
            return result;
        }
    }
}