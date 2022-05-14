class Solution {
    public boolean isMatch(String s, String p) {
        StringBuilder st = new StringBuilder();
        boolean check = false;
        int count = 0;
        for(int i=0; i<p.length();i++){
            if(p.charAt(i)!='*'){
                st.append(p.charAt(i));
                check=false;
            }else if(!check){
                count++;
                st.append(p.charAt(i));
                check=true;
            }
        }
        boolean[][] cache = new boolean[s.length()+1][st.length()+1];
        for(int i=0; i<s.length()+1; i++){
            Arrays.fill(cache[i],true);
        }
        isMatch(s,st.toString(),0,0,cache);
        // for(int i=0;i<cache.length;i++){
        //     for(int j=0; j<cache[0].length;j++){
        //         System.out.print(cache[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        return cache[0][0];
    }
    
    public boolean isMatch(String s, String p, int s_idx, int p_idx, boolean[][] check){
        if(p.length()<=p_idx){
             check[s_idx][p_idx] = s.length()<=s_idx;
            return check[s_idx][p_idx];
        }
        if(check[s_idx][p_idx]==false){
            return check[s_idx][p_idx];
        }else{
            boolean result = (s.length()>s_idx && (s.charAt(s_idx)==p.charAt(p_idx) || p.charAt(p_idx) == '?'));

            if(p.charAt(p_idx)=='*'){
                if(s.length()>s_idx){
                    result = isMatch(s,p,s_idx+1,p_idx,check);
                }
                check[s_idx][p_idx] = result || isMatch(s,p, s_idx, p_idx+1,check);
                return check[s_idx][p_idx];
            }else{
                check[s_idx][p_idx] = result && isMatch(s, p, s_idx+1, p_idx+1,check);
                return check[s_idx][p_idx];
            }
        }
    }
}