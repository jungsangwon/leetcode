class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }else{
            for(int i=s.length()-1; i>=0; i--){
                char c = s.charAt(i);
                int idx = t.lastIndexOf(c);
                if(t.lastIndexOf(c)<0){
                    return false;
                }else{
                    t = t.substring(0,idx);
                }
            }
            return true;
        }
    }
}