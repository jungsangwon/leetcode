class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        int base = 1;
        for(int i=1; i<=n; i++){
            if(i==base*2){
                base *= 2;
            }
            result[i] = result[i-base]+1;
        }
        return result;
    }
}