class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<>(){
           @Override
            public int compare(int[] a , int[] b){
                if(a[0]==b[0]){
                    return b[1] - a[1];
                }else{
                    return a[0] - b[0];
                }
            }
        });
        int result = 0;
        int[] top = new int[envelopes.length];
        for(int i=0; i<envelopes.length; i++){
            int idx = Arrays.binarySearch(top,0,result,envelopes[i][1]);
            if(idx<0){
                idx = -idx -1;
            }
            if(idx == result){
                result++;
            }
            top[idx] = envelopes[i][1];
        }
        return result;
    }
}