class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        boolean[] check = new boolean[n+1];
        int idx = 0;
        while(k>1){
            result[idx] = n;
            check[n]=true;
            idx++;
            result[idx] = n-k;
            check[n-k]=true;
            idx++;
            n--;
            k-=2;
        }
        for(int i=idx; i<result.length; i++){
            while(check[n]){
                n--;
            }
            result[i] = n--;
        }
        return result;
    }
}