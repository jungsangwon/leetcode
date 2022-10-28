class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                if(isPalindrome(s.substring(left,right))||isPalindrome(s.substring(left+1,right+1))){
                    return true;
                }else{
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
    
    public boolean isPalindrome(String s){
        System.out.println(s);
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}