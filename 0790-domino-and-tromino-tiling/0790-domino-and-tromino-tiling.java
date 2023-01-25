class Solution {
    int mod = 1000000007;
    public int numTilings(int n) {
        return numTilings(n,0,new int[n+1]);
    }
    
    public int numTilings(int n, int now, int[] dp) {
        if(now>n){
            return 0;
        }else if(now == n){
            return 1;
        }else{
            if(dp[now]!=0){
                return dp[now];
            }
            int result = 0;
            result += numTilings(n,now+1,dp);
            result += numTilings(n,now+2,dp);
            result %= mod;
            int tmp = numTilings(n,now+3,dp);
            result += tmp;
            result %= mod;
            result += tmp;
            result %= mod;
            for(int i=4; now+i<=n; i+=2){
                tmp = numTilings(n,now+i,dp);
                result += tmp;
                result %= mod;
                result += tmp;
                result %= mod;
            }
            for(int i=5; now+i<=n; i+=2){
                tmp = numTilings(n,now+i,dp);
                result += tmp;
                result %= mod;
                result += tmp;
                result %= mod;
            }
            dp[now] = result;
            return result;
        }
    }
}