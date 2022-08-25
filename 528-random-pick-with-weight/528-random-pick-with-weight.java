class Solution {
    TreeMap<Integer,Integer> map;
    int sum;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        map = new TreeMap<>();
        sum = 0;
        for(int i=0; i<w.length; i++){
            sum += w[i];
            map.put(sum,i);
        }
    }
    
    public int pickIndex() {
        int pick = random.nextInt(sum)+1;
        return map.get(map.ceilingKey(pick));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */