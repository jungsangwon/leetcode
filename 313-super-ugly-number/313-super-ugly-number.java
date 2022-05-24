class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] index = new int[primes.length];
        int[] factor = new int[primes.length];
        for(int i=0; i<primes.length; i++){
            factor[i] = primes[i];
        }
        for(int i=1;i<n;i++){
            int min = factor[0];
            for(int j=1;j<factor.length;j++){
                min = Math.min(min,factor[j]);
            }
            ugly[i] = min;
            for(int j=0; j<primes.length; j++){
                if(factor[j] == min){
                    factor[j] = primes[j]*ugly[++index[j]];
                }
            }
        }
        return ugly[n-1];
    }
}