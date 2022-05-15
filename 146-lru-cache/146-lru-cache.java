class LRUCache {
    HashMap<Integer,Integer> map = new HashMap<>();
    HashMap<Integer,Integer> count = new HashMap<>();
    Queue<Integer> qu = new LinkedList<>();
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        qu = new LinkedList<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            if(count.containsKey(key)){
                capacity++;
            }
            qu.add(key);
            count.put(key,count.getOrDefault(key,0)+1);
            while(qu.size()>capacity){
                int k = qu.poll();
                if(count.get(k)==1){
                    map.remove(k);
                    count.remove(k);
                }else{
                    capacity--;
                    count.put(k,count.get(k)-1);
                }
            }
            return map.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(count.containsKey(key)){
            capacity++;
        }
        qu.add(key);
        count.put(key,count.getOrDefault(key,0)+1);
        while(qu.size()>capacity){
            int k = qu.poll();
            if(count.get(k)==1){
                map.remove(k);
                count.remove(k);
            }else{
                capacity--;
                count.put(k,count.get(k)-1);
            }
        }
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */