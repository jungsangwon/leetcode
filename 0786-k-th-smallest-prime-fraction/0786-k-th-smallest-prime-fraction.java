class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Position> pq = new PriorityQueue<Position>((p1, p2)->arr[p1.start] * arr[p2.end] - arr[p2.start] * arr[p1.end]);
        boolean[][] dp = new boolean[arr.length][arr.length];
        int[] result = new int[2];
        pq.add(new Position(0,arr.length-1));
        for(int i = 1; i<k; i++){
            Position p = pq.poll();
            // System.out.println(arr[p.start]+"/"+arr[p.end]);
            if(p.end-p.start>1){
                if(!dp[p.start+1][p.end]){
                    pq.add(new Position(p.start+1,p.end));
                    dp[p.start+1][p.end] = true;
                }
                if(!dp[p.start][p.end-1]){
                    pq.add(new Position(p.start,p.end-1));
                    dp[p.start][p.end-1] = true;
                }
            }
        }
        Position p = pq.poll();
        // System.out.println("result");
        // System.out.println(arr[p.start]+"/"+arr[p.end]);
        result[0] = arr[p.start];
        result[1] = arr[p.end];
        return result;
    }
}

class Position{
    int start;
    int end;
    public Position(int start, int end){
        this.start = start;
        this.end = end;
    }
}