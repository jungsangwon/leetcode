class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] count = new int[52];
        for(int i=0; i<stones.length(); i++){
            char now = stones.charAt(i);
            if(now<='Z'){
                count[now-'A']++;
            }else{
                count[26+now-'a']++;
            }
        }
        int result = 0;
        for(int i=0; i<jewels.length(); i++){
            char now = jewels.charAt(i);
            if(now<='Z'){
                result += count[now-'A'];
            }else{
                result += count[26+now-'a'];
            }
        }
        return result;
    }
}