class Solution {
    public String toLowerCase(String s) {
        char[] c = s.toCharArray();
        int dif = 'A' - 'a';
        for(int i=0; i<c.length; i++){
            if(c[i]>='A'&&c[i]<='Z'){
                c[i] -= dif;
            }
        }
        return String.valueOf(c);
    }
}