class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        
        int tmp = x;
        long result = 0;
        
        while(0!=tmp){
            result = result * 10 + tmp%10;
            tmp = tmp/10;
        }
        
        if(result > Integer.MAX_VALUE){
            return false;
        }
        
        return (int)result == x;
    }
}