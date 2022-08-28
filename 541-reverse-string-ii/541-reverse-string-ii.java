class Solution {
    public String reverseStr(String s, int k) {
        if(s.length()<k){
            StringBuilder sb = new StringBuilder(s);
            return sb.reverse().toString();
        }else if(s.length()<=2*k){
            StringBuilder sb = new StringBuilder(s.substring(0,k));
            return sb.reverse().toString() + s.substring(k);
        }else{
            return reverseStr(s.substring(0,2*k),k)+reverseStr(s.substring(2*k),k);
        }
    }
}