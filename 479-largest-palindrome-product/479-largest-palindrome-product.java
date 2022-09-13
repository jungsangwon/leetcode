class Solution {
    public int largestPalindrome(int n) {
        long max = (long)Math.pow(10, n) - 1;
        long min = max / 10;

        for (long h = max; h > min; h--) {
            long left = h, right = 0;
            long palindrom = 0;
            long tmp = h;
            while(tmp!=0){
                right = right*10 + tmp%10;
                left *= 10;
                tmp /= 10;
            }
            palindrom = left + right;

            for (long i = max; i > min; i--) {
                long j = palindrom / i;
                if (j > i){
                    break;
                } 
                if(palindrom % i == 0){
                    return (int)(palindrom % 1337);
                }
            }
        }

        return 9;
    }
}