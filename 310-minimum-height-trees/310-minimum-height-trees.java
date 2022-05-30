class Solution {
    ArrayList<ArrayList<Integer>> adjList(int[][] edges,int V,int[] ind){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++)list.add(new ArrayList<Integer>());
        for(int[] edge: edges){
            ind[edge[0]]++;
            ind[edge[1]]++;
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        return list;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] ind = new int[n];
        ArrayList<ArrayList<Integer>> list = adjList(edges,n,ind);
        List<Integer> res = new ArrayList<>();
        if(n<=0)return res;
        if(n==1){
            res.add(0);
            return res;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==1)q.add(i);
        }
        while(n > 2){
            int size = q.size(); 
            n -= size;
            while(size > 0){
                int u = q.poll();
                for(int v : list.get(u)){
                    ind[v]--;
                    if(ind[v]==1)q.add(v);
                }
                size --;
            }
        }
        while(!q.isEmpty())res.add(q.poll());
        return res;
    }
}