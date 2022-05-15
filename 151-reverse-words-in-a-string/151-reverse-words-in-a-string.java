class Solution {
    public String reverseWords(String s) {
        StringBuilder st = new StringBuilder();
        s = s.trim();
        String[] tmp = s.split(" ");
        for(int i=tmp.length-1; i>=0; i--){
            if(tmp[i].equals("")){
                continue;
            }
            st.append(tmp[i]);
            st.append(" ");
        }
        return st.substring(0,st.length()-1).toString();
    }
}