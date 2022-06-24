class Solution {
    public char findTheDifference(String s, String t) {
        int[] c = new int[26];
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++){
            c[cs[i]-'a']++;
        }
        char[] ct = t.toCharArray();
        for(int i=0; i<ct.length; i++){
            int idx = ct[i]-'a';
            c[idx]--;
            if(c[idx]<0){
                return ct[i];
            }
        }
        return ' ';
    }
}