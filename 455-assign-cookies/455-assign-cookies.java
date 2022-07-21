class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gidx = 0;
        int sidx = 0;
        while(true){
            if(sidx>=s.length||gidx>=g.length){
                break;
            }else if(g[gidx]<=s[sidx]){
                count++;
                sidx++;
                gidx++;
            }else{
                sidx++;
            }
        }
        return count;
    }
}
