class Solution {
    public int findSubstringInWraproundString(String p) {
        if(p.length()==1){
            return 1;
        }
        int result = 0;
        int[] count = new int[26];
        char[] c= p.toCharArray();
        char before = c[0];
        int now = 1;
        for(int i=1; i<c.length; i++){
            if(isContinue(before,c[i])){
                now++;
            }else{
                int limit = Math.min(26,now);
                for(int j=0; j<limit; j++){
                    count[before-'a'] = Math.max(now,count[before-'a']);
                    before = beforeChar(before);
                    now--;
                }
                now = 1;
            }
            before = c[i];
        }
        int limit = Math.min(26,now);
        for(int j=0; j<limit; j++){
            count[before-'a'] = Math.max(now,count[before-'a']);
            before = beforeChar(before);
            now--;
        }
        for(int i=0; i<26; i++){
            result += count[i];
        }
        return result;
    }
    
    public boolean isContinue(char b, char a){
        if(b=='z'){
            return a=='a';
        }else{
            return b+1 == a;
        }
    }
    
    public char beforeChar(char c){
        if(c=='a'){
            return 'z';
        }else{
            return (char)(c-1);
        }
    }
}