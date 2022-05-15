class Solution {
    public int hIndex(int[] citations) {
        int result = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int tmp = citations.length - i;
            int min = Math.min(tmp,citations[i]);
            if(min>result){
                result = min;
            }
        }
        return result;
    }
}