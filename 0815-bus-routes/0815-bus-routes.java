class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        int n = routes.length;
        boolean[][] map = new boolean[n][n];
        int[] now = new int[n];
        HashMap<Integer,List<Integer>> spot = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                List<Integer> list = spot.getOrDefault(routes[i][j],new ArrayList<>());
                list.add(i);
                spot.put(routes[i][j],list);
            }
        }
        Arrays.fill(now,Integer.MAX_VALUE);
        if(!spot.containsKey(source)){
            return -1;
        }
        for(int a : spot.get(source)){
            now[a] = 1;
        }
        if(!spot.containsKey(target)){
            return -1;
        }
        for(int a : spot.get(target)){
            if(now[a]==1){
                return 1;
            }
            hashSet.add(a);
        }
        
        for(List<Integer> list : spot.values()){
            if(list.size()>1){
                for(int i=0; i<list.size(); i++){
                    int a = list.get(i);
                    for(int j=i+1; j<list.size(); j++){
                        int b =list.get(j);
                        map[a][b]=true;
                        map[b][a]=true;
                    }
                }
            }
        }
        boolean check = false;
        while(!check){
            check = true;
            for(int i : hashSet){
                if(now[i]!=Integer.MAX_VALUE){
                    return now[i];
                }
            }
            int[] tmp = now.clone();
            for(int i=0; i<n; i++){
                if(tmp[i]!=Integer.MAX_VALUE){
                    for(int j=0; j<n; j++){
                        if(map[i][j] && tmp[j]>tmp[i]+1){
                            tmp[j] = tmp[i]+1;
                            check = check && false;
                        }
                    }
                }
            }
            now = tmp;
        }
        return -1;
    }
}