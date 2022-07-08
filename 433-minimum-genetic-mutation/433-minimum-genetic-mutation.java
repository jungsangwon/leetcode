class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)){
            return 0;
        }
        HashSet<String> hashSet = new HashSet<>();
        for(String gene : bank){
            hashSet.add(gene);
        }
        if(!hashSet.contains(end)){
            return -1;
        }
        char[] c = {'A','C','G','T'};
        int result = 1;
        Queue<String> qu = new LinkedList<>();
        qu.add(start);
        
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                String str = qu.poll();
                for(int j=0; j<8; j++){
                    StringBuilder now = new StringBuilder(str);
                    for(int k=0; k<4; k++){
                        now.setCharAt(j,c[k]);
                        String key = now.toString();
                        if(end.equals(key)){
                            return result;
                        }else if(hashSet.contains(key)){
                            qu.add(key);
                            hashSet.remove(key);
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}