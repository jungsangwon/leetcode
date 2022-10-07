class Solution {
    public String predictPartyVictory(String senate) {
        int rc = 0, dc = 0;
        char[] s = senate.toCharArray();
        for (char c : s){
            if(c=='R'){
                rc++;
            }else{
                dc++;
            }
        }
        int rk = 0, dk = 0;
        int i = 0, n = s.length;
        while (rc > 0 && dc > 0) {
            if (s[i] != '*'){
                if(s[i] == 'R' && rk > 0){
                    rk--;
                    s[i] = '*';
                    rc--;
                }else if(s[i] == 'D' && dk > 0){
                    dk--;
                    s[i] = '*';
                    dc--;
                }else{
                    if(s[i]=='R'){
                        dk++;
                    }else{
                        rk++;
                    }
                }
            }
            i = (i+1)%n;
        }
        return rc > 0 ? "Radiant" : "Dire";
    }
}
