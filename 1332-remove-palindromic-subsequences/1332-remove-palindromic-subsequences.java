class Solution {
    public int removePalindromeSub(String s) {
        if(isPalindrome(s)){
            return 1;
        }else{
            return 2;
        }
    }
    
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        char[] c = s.toCharArray();
        while(left<right){
            if(c[left++]!=c[right--]){
                return false;
            }
        }
        return true;
    }
}