class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        int total = tickets.size()+1;
        HashMap<String,TreeMap<String,Integer>> map = new HashMap<>();
        HashMap<String,Integer> visit = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<tickets.size(); i++){
            List<String> way = tickets.get(i);
            String to = way.get(1);
            String from = way.get(0);
            TreeMap<String,Integer> count = map.getOrDefault(from,new TreeMap<>());
            count.put(to,count.getOrDefault(to,0)+1);
            map.put(from,count);
        }
        String from = "JFK";
        result.add(from);
        findItinerary(map,visit,from,total,result);
        return result;
    }
    
    public boolean findItinerary(HashMap<String,TreeMap<String,Integer>> map, HashMap<String,Integer> visit, String now, int total, List<String> result){
        if(result.size() == total){
            return true;
        }
        if(map.containsKey(now)){
            for(String to : map.get(now).keySet()){
                String key = now+to;
                if(visit.getOrDefault(key,0)<map.get(now).get(to)){
                    visit.put(key,visit.getOrDefault(key,0)+1);
                    result.add(to);
                    if(findItinerary(map,visit,to,total,result)){
                        return true;
                    }
                    visit.put(key,visit.get(key)-1);
                    result.remove(result.size()-1);
                }
            }
        }
        return false;
    }
}