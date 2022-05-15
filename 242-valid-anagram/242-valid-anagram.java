class Solution {
    public boolean isAnagram(String s, String t) {
        int[] check = new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            check[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            check[t.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(check[i]!=0){
                return false;
            }
        }
        
        return true;
    }
}