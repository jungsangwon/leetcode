class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i=0; i<order.length(); i++){
            int cnt = count[order.charAt(i)-'a'];
            for(int j=0; j<cnt; j++){
                sb.append(order.charAt(i));
            }
            count[order.charAt(i)-'a'] = 0;
        }
        
        for(int i=0; i<26; i++){
            int cnt = count[i];
            for(int j=0; j<cnt; j++){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
}