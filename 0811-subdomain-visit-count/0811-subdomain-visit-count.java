class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<cpdomains.length; i++){
            String[] tmp = cpdomains[i].split(" ");
            addVisit(tmp[1],map,Integer.parseInt(tmp[0]));
        }
        
        for(String key : map.keySet()){
            result.add(map.get(key)+" "+key);
        }
        return result;
    }
    
    public void addVisit(String domain, HashMap<String,Integer> map, int count){
        String[] subDomain = domain.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i=subDomain.length-1; i>=0; i--){
            sb.insert(0,subDomain[i]);
            sb.insert(0,".");
            String tmp = sb.substring(1).toString();
            map.put(tmp,map.getOrDefault(tmp,0)+count);
        }
    }
}