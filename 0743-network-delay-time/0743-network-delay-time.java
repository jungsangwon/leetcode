class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int r = times.length, max = Integer.MAX_VALUE;
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<r;i++){
            int[] nums = times[i];
            int u = nums[0];
            int v = nums[1];
            List<Integer> list = map.getOrDefault(u,new ArrayList<>());
            list.add(i);
            map.put(u,list);
        }
        if(map.get(K) == null){
            return -1;
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist,max);
        
        dist[K] = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(K);
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            int t = dist[u];
            List<Integer> list = map.get(u);
            if(list == null)
                continue;
            
            for(int n:list){
                int v = times[n][1];
                int time = times[n][2];
                 if(dist[v] > t + time){
                    dist[v] = t + time;
                    queue.add(v);
                }                
            }
        }
        
        int res = -1;
        for(int i=1;i<=N;i++){
            int d = dist[i];
            if(d == max){
                return -1;
            }
            res = Math.max(res,d);
        }
        
        return res;
    }
}