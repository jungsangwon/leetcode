class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int now = s.length();
        for(int i=0; i<s.length(); i++){
            if(c==s.charAt(i)){
                now=0;
            }
            result[i] = now;
            now++;
        }
        now = s.length();
        for(int i=s.length()-1; i>=0; i--){
            if(c==s.charAt(i)){
                now=0;
            }
            result[i] = Math.min(result[i],now);
            now++;
        }
        return result;
    }
}