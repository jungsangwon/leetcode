class Solution {
    public int arrangeCoins(int n) {
        int result = 1;
        while(n>=result){
            n-=result;
            result++;
        }
        return result-1;
    }
}