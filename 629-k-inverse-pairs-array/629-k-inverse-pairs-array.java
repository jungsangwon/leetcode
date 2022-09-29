class Solution {
     /*
    Define an n-array to be the Let a(n, k) be the number of n-arrays such that there are k inverse pairs.
	
    We have
    a(n, k) = a(n - 1, k)           (if we put n at the end of our (n-1)-array)
            + a(n - 1, k - 1)       (if we put n at the second-to-last position of our (n-1)-array)
            + ...
            + a(n - 1, k - (n - 1)) (if we put n at the beginning of our (n-1)-array)
    
    We can optimize this by noting that this is equivalent to
    a(n, k) = a(n, k - 1)
            + a(n - 1, k)
            - a(n - 1, (k - 1) - (n - 1)).
    
    In addition, since we only need values up to k, we only need to keep track of values for a(0...n, 0...k) to
    find a(n, k) (i.e. we do not necessarily need to find (a(0...n, 0...n * (n - 1)/2).
    
	This is O(nk) time and O(nk) memory.
    */
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[][] dp = new int[n][k+1];
        for(int i =0; i < n;i++){
            dp[i][0]  = 1;
        }
        for(int i = 1; i < n; i++){
            int last = Math.min(i*(i+1)/2, k);
            for(int j = 1; j <= last; j++){
                int l = Math.max(j-i,0); 
                dp[i][j] = dp[i-1][j];
                if(l!=0){
                    dp[i][j] =(dp[i][j] - dp[i-1][l-1] + mod)%mod;
                }
                dp[i][j] = (dp[i][j] + dp[i][j-1])%mod; //prefix sum
            }
        }
        return dp[n-1][k];
    }
}