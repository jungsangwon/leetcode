class Solution {
    public boolean canTransform(String start, String end) {
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        for(int i=0; i<s.length; i++){
            if(s[i]!=e[i]){
                if(s[i]=='X' && e[i] == 'L'){
                   int idx = i;
                   while(idx<s.length && s[idx]=='X'){
                       idx++;
                   }
                   if(idx>=s.length){
                       return false;
                   }
                   if(s[idx]=='R'){
                       return false;
                   }else{
                       s[idx]='X';
                       s[i] = 'L';
                   }
                }else if(s[i]=='R'&&e[i]=='X'){
                    int idx = i;
                    while(idx<s.length && s[idx]=='R'){
                        idx++;
                    }
                    if(idx>=s.length){
                       return false;
                    }
                    if(s[idx]=='L'){
                        return false;
                    }else{
                        s[idx]='R';
                        s[i] = 'X';
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
