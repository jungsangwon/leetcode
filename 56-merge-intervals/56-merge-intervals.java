class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prev[1] < curr[0]) {
                res.add(prev);
                prev = curr;
            } else {
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        res.add(prev);
        return res.toArray(new int[0][2]);
    }
}