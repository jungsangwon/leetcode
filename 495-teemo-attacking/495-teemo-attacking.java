class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for(int i=0; i<timeSeries.length-1; i++){
            int tmp = timeSeries[i+1]-timeSeries[i];
            result += Math.min(duration,tmp);
        }
        result+=duration;
        return result;
    }
}