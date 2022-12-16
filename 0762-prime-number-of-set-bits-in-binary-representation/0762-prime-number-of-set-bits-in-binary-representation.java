class Solution {
    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for(int i=left; i<=right; i++){
            String now = Integer.toBinaryString(i);
            int count = 0;
            for(int j=0; j<now.length();j++){
                if(now.charAt(j)=='1'){
                    count++;
                }
            }
            if(isPrime(count)==1){
                result++;
            }
        }
        return result;
    }
    public int isPrime(int n) {
        if(n==1){
            return 0;
        }
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return 0;
          }
        }
        return 1;
    }
}