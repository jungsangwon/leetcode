class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] idx = new int[26];
        char[] c= s.toCharArray();
        for(int i=0; i<c.length; i++){
            count[c[i]-'a']++;
            idx[c[i]-'a']=i;
        }
        int result = c.length;
        for(int i=0; i<26; i++){
            if(count[i]==1){
                result = Math.min(result,idx[i]);
            }
        }
        if(result == c.length){
            return -1;
        }else{
            return result;
        }
    }
}