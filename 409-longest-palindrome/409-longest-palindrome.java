class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] c = new int[58];
        for(int i=0; i<s.length();i++){
            c[s.charAt(i)-'A']++;
        }
        boolean check = false;
        for(int i=0; i<58; i++){
            if(c[i]%2==1){
                result+= c[i];
                result--;
                check = true;
            }else{
                result += c[i];
            }
        }
        if(check){
            result++;
        }
        return result;
    }
}