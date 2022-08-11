class Solution {
    int[][] rects;
    Random random = new Random();
    TreeMap<Integer,int[]> map;
    int sum;

    public Solution(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        for(int i=0; i<rects.length; i++){
            int x = rects[i][2]-rects[i][0]+1;
            int y = rects[i][3]-rects[i][1]+1;
            sum += (x*y);
            map.put(sum,rects[i]);
        }
    }
    
    public int[] pick() {
        int[] result = new int[2];
        int[] now = map.get(map.ceilingKey(random.nextInt(sum)+1));
        int x = now[2]-now[0]+1;
        int y = now[3]-now[1]+1;
        result[0] = now[0] + random.nextInt(x);
        result[1] = now[1] + random.nextInt(y);
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */