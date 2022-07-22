class LFUCache {
    int count = 0;
    int capacity;
    TreeMap<Integer,Queue<Pair>> counter;
    HashMap<Integer,Pair> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        counter = new TreeMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Pair p = map.get(key);
            int value = p.val;
            p.count++;
            Queue<Pair> qu = counter.getOrDefault(p.count,new LinkedList<>());
            qu.add(p);
            counter.put(p.count,qu);
            return value;
        }
    }
    
    public void put(int key, int value) {
        if(capacity>0){
            if(map.containsKey(key)){
                Pair p = map.get(key);
                p.count++;
                p.val = value;
                Queue<Pair> qu = counter.getOrDefault(p.count,new LinkedList<>());
                qu.add(p);
                counter.put(p.count,qu);
                map.put(key,p);
            }else{
                count++;
                if(count>capacity){
                    for(int count : counter.keySet()){
                        Queue<Pair> qu = counter.get(count);
                        boolean check = false;
                        while(!qu.isEmpty()){
                            Pair tmp = qu.poll();
                            if(tmp.count == count){
                                check = true;
                                map.remove(tmp.key);
                                break;
                            }
                        }
                        if(check){
                            break;
                        }
                    }
                }
                Pair p = new Pair(value, key);
                Queue<Pair> qu = counter.getOrDefault(p.count,new LinkedList<>());
                qu.add(p);
                counter.put(p.count,qu);
                map.put(key,p);
            }
        }
    }
}

class Pair{
    int val;
    int count;
    int key;
    public Pair(int val, int key){
        this.key = key;
        this.val = val;
        this.count = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */