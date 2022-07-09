class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
            }
        });
        int start = intervals[0][0];
        int last = intervals[0][1];
        int count = 0;
        for(int i=1; i<intervals.length; i++){
            if(start == intervals[i][0]){
                count++;
            }else{
                start = intervals[i][0];
                if(last>intervals[i][0]){
                    count++;
                    last = Math.min(last, intervals[i][1]);
                }else{
                    last = intervals[i][1];
                }
            }
        }
        
        return count;
    }
}