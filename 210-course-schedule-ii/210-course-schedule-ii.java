class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        int[] result = new int[numCourses];
        Queue<Integer> qu = new LinkedList<>();
        int index = 0;
        
        for(int i=0; i<prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int next = prerequisites[i][0];
            if(!map.containsKey(pre) || !map.get(pre).contains(next)){
                HashSet<Integer> tmp = map.getOrDefault(pre,new HashSet<>());
                tmp.add(next);
                map.put(pre,tmp);
                count.put(next,count.getOrDefault(next,0)+1);
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(!count.containsKey(i)){
                qu.add(i);
            }
        }
        
        while(!qu.isEmpty()){
            int tmp = qu.poll();
            result[index++] = tmp;
            if(map.containsKey(tmp)){
                for(int i : map.get(tmp)){
                    if(count.get(i)==1){
                        qu.add(i);
                    }else{
                        count.put(i,count.get(i)-1);
                    }
                }
            }
        }
        
        if(index==numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
}