class Solution {
    public boolean backspaceCompare(String s, String t) {
        return remove(s).equals(remove(t));
    }
    
    public String remove(String s){
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for(int i=0 ;i<c.length; i++){
            if(c[i]=='#'){
               if(sb.length()!=0){
                   sb.deleteCharAt(sb.length()-1);
               }
            }else{
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
}