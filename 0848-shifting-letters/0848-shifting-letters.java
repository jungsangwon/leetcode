class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] c = s.toCharArray();
        int sum = 0;
        for(int i=shifts.length-1; i>=0; i--){
            sum+=shifts[i];
            sum%=26;
            c[i] = shift(c[i],sum);
        }
        return String.valueOf(c);
    }
    
    public char shift(char a, int n){
        char result = (char)(a+n);
        if(result>'z'){
            result = (char)(result-26);
        }
        return result;
    }
}