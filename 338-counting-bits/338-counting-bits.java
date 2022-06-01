class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=1; i<=n; i++){
            result[i] = counting(i);
        }
        return result;
    }
    
    public int counting(int n){
        int result = 0;
        while(n!=0){
            if(n%2==1){
                result++;
            }
            n = n/2;
        }
        return result;
    }
}