class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int len = s.length();
        for(int i = 0; i<len; i++){
            if(result.length()>=2*(s.length()-i)){
                break;
            }
            String tmp = getLongestPalindromeWithOdd(s,i);
            if(tmp.length()>result.length()){
                result = tmp;
            }
            
            if(i+1 != len && s.charAt(i) == s.charAt(i+1)){
                tmp = getLongestPalindromeWithEven(s,i,i+1);
                if(tmp.length()>result.length()){
                    result = tmp;
                }
            }
        }
        
        return result;
    }
    
    public String getLongestPalindromeWithOdd(String s, int index){
        String result = String.valueOf(s.charAt(index));
        int right = s.length() - index -1;
        int left = index;
        int min = right > left ? left : right;
        for(int i = 1; i<=min; i++){
            if(s.charAt(index-i) == s.charAt(index+i)){
                result = s.charAt(index-i) + result + s.charAt(index+i);
            }else{
                break;
            }
        }
        return result;
    }
    
    public String getLongestPalindromeWithEven(String s, int index1, int index2){
        String result = String.valueOf(s.charAt(index1)) + s.charAt(index2);
        int right = s.length() - index2 -1;
        int left = index1;
        int min = right > left ? left : right;
        for(int i = 1; i<=min; i++){
            if(s.charAt(index1-i) == s.charAt(index2+i)){
                result = s.charAt(index1-i) + result + s.charAt(index2+i);
            }else{
                break;
            }
        }
        return result;
    }
}