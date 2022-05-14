class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int i=0; i < intervals.length; i++){
            result.add(intervals[i]);
        }
        result.add(newInterval);
        result.sort((a,b) -> a[0] - b[0]);
        
        int[] now = result.get(0);
        for(int i=1; i<result.size(); i++){
            if(now[1]>=result.get(i)[0]){
                int[] tmp = result.get(i);
                now[0] = Math.min(now[0],tmp[0]);
                now[1] = Math.max(now[1],tmp[1]);
                result.remove(i);
                i--;
            }else{
                now = result.get(i);
            }
        }
        
        return result.toArray(new int[0][]);
    }
}