class Solution {
    public int trailingZeroes(int n) {
        int cnt2 = 0;
        int cnt5 = 0;
        for(int i=2;i<=n;i++){
            int now = i;
            while(now%5==0){
                cnt5++;
                now=now/5;
            }
            while(now%2==0){
                cnt2++;
                now=now/2;
            }
        }
        
        return Math.min(cnt2,cnt5);
    }
}