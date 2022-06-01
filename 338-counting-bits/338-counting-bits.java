class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=1; i<=n; i++){
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}