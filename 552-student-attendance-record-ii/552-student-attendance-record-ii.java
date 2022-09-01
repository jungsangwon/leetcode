class Solution {
    public int checkRecord(int n) {
        int mod = 1000000007;
        long[] p = new long[n+1];
        long[] l = new long[n+1];
        p[0] = p[1] = 1;
        l[1] = 1;
        for(int i=2; i<=n; i++){
            p[i] = (p[i-1] + l[i-1])%mod;
            l[i] = (p[i-1]+p[i-2])%mod;
        }
        long result = (p[n] + l[n]) % mod;

        for(int i = 0; i < n; i++){ 
            long a = ((p[i] + l[i])%mod * (p[n-i-1] + l[n-i-1])%mod )% mod;
            result = (result + a) % mod;
        }
        
        return (int)result;
    }
}