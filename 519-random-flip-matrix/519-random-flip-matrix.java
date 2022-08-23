class Solution {
    private int M, N;
    private HashSet<Integer> set;
    private Random r;
    public Solution(int n_rows, int n_cols) {
        M = n_rows;
        N = n_cols;
        r = new Random();
        set = new HashSet<Integer>();
    }
    private int hashCode(int x, int y){
        // Szudzik's Pairing Function - guaranteed to be unique
        if(x < y){
           return x + y*y;
        }else{
           return x*x + x + y;
        }
    }
    
    public int[] flip() {
        int row, col;
        while(true){
            row = r.nextInt(M);
            col = r.nextInt(N);
            if(set.add(hashCode(row, col)))
                return new int[]{row, col};
        }
    }
    
    public void reset() {
        set.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */