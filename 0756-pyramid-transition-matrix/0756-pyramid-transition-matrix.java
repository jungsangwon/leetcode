class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String,List<String>> map = new HashMap<>();
        HashMap<String,Boolean> dp = new HashMap<>();
        for(String str : allowed){
            String key = str.substring(0,2);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str.substring(2,3));
            map.put(key,list);
        }
        return pyramidTransition(bottom,map,dp);
    }
    
    public boolean pyramidTransition(String bottom, HashMap<String,List<String>> map, HashMap<String,Boolean> dp) {
        if(dp.containsKey(bottom)){
            return dp.get(bottom);
        }
        if(bottom.length()==1){
            return true;
        }
        boolean result = false;
        List<String> next = getNext(bottom,map);
        if(next!=null){
            for(String s : next){
                result = pyramidTransition(s,map,dp);
                if(result){
                    break;
                }
            }
            dp.put(bottom,result);
        }
        return result;
    }
    
    public List<String> getNext(String bottom, HashMap<String,List<String>> map){
        Queue<String> result = new LinkedList<>();
        String t = bottom.substring(0,2);
        if(map.containsKey(t)){
            result.addAll(map.get(t));
        }else{
            return null;
        }
        for(int i=2; i<bottom.length(); i++){
            String now = bottom.substring(i-1,i+1);
            if(!map.containsKey(now)){
                return null;
            }else{
                int size = result.size();
                List<String> list = map.get(now);
                for(int j=0; j<size; j++){
                    String str =result.poll();
                    for(String tmp : list){
                        result.add(str+tmp);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}