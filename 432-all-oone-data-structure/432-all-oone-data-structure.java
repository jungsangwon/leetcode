class AllOne {
    TreeMap<Integer,HashSet<String>> treeMap;
    HashMap<String,Integer> count;

    public AllOne() {
        treeMap = new TreeMap<>();
        count = new HashMap<>();
    }
    
    public void inc(String key) {
        int c = 1;
        if(count.containsKey(key)){
            c = count.get(key);
            treeMap.get(c).remove(key);
            if(treeMap.get(c).isEmpty()){
                treeMap.remove(c);
            }
            count.put(key,++c);
        }else{
            count.put(key,1);
        }
        HashSet<String> tmp = treeMap.getOrDefault(c,new HashSet<>());
        tmp.add(key);
        treeMap.put(c,tmp);
    }
    
    public void dec(String key) {
        int c = count.get(key);
        treeMap.get(c).remove(key);
        if(treeMap.get(c).isEmpty()){
            treeMap.remove(c);
        }
        count.put(key,--c);
        if(c!=0){
            HashSet<String> tmp = treeMap.getOrDefault(c,new HashSet<>());
            tmp.add(key);
            treeMap.put(c,tmp);
        }else{
            count.remove(key);
        }
    }
    
    public String getMaxKey() {
        if(treeMap.isEmpty()){
            return "";
        }
        for(String res : treeMap.get(treeMap.lastKey())){
            return res;
        }
        return "";
    }
    
    public String getMinKey() {
        if(treeMap.isEmpty()){
            return "";
        }
        for(String res : treeMap.get(treeMap.firstKey())){
            return res;
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */