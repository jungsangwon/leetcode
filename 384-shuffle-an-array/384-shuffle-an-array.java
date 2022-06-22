class Solution {
    int[] origin;
    int[] now;
    
    public Solution(int[] nums) {
        this.origin = nums;
        this.now = nums.clone();
    }
    
    public int[] reset() {
        now = origin.clone();
        return now;
    }
    
    public int[] shuffle() {
        Random random = new Random();
        for(int i=0; i<now.length; i++){
            int ridx = random.nextInt(now.length) + i;
            if(ridx>=now.length){
                ridx -= now.length;
            }
            int tmp = now[i];
            now[i] = now[ridx];
            now[ridx] = tmp;
        }
        return now;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */