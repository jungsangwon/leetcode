class Solution {
    public int binaryGap(int n) {
        int result = 0;
        int start = -1;
        int end = -1;
        int idx = 0;
        while(n!=0){
            int tmp = n%2;
            if(tmp == 1){
                end = start;
                start = idx;
            }
            if(end!=-1){
                result = Math.max(result,start - end);
            }
            idx++;
            n=n/2;
        }
        return result;
    }
}