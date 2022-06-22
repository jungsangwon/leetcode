class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] c = new int[26];
        for(int i=0; i<magazine.length();i++){
            c[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            c[ransomNote.charAt(i)-'a']--;
        }
        for(int i=0; i<c.length; i++){
            if(c[i]<0){
                return false;
            }
        }
        return true;
    }
}