class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] map = new int[26];
        int maxf = 0;
        int left = 0;
        int maxlen = 0;
        for(int i=0;i<n;i++){
            map[s.charAt(i)-'A']++;
            maxf = Math.max(maxf,map[s.charAt(i)-'A']);
            int windowSize = i-left+1;
            if(windowSize - maxf > k){
                map[s.charAt(left)-'A']--;
                left++;
            }
            
            maxlen = Math.max(maxlen,i-left+1);
        }
        return maxlen;
    }
}