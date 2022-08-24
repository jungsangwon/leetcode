class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary,(String a, String b)->a.length()==b.length()?a.compareTo(b):b.length()-a.length());
        for(String t : dictionary){
            if(isSubstring(s,t)){
                return t;
            }
        }
        
        return "";
    }
    
    public boolean isSubstring(String s, String a){
        if(s.length()<a.length()){
            return false;
        }else{
            int idx1 = 0;
            int idx2 = 0;
            while(idx1<s.length() &&idx2<a.length()){
                if(s.charAt(idx1)==a.charAt(idx2)){
                    idx2++;
                }
                idx1++;
            }
            return idx2==a.length();
        }
    }
}