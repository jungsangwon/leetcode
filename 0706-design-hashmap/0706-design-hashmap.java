class MyHashMap {
    List<Integer> idx;
    List<Integer> val;

    public MyHashMap() {
        this.idx = new ArrayList<>();
        this.val = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int left = 0;
        int right = idx.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(idx.get(mid)==key){
                left = mid;
                break;
            }else if(idx.get(mid)>key){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(left==idx.size() || idx.get(left)!=key){
            idx.add(left,key);
            val.add(left,value);
        }else{
            val.remove(left);
            val.add(left,value);
        }
    }
    
    public int get(int key) {
        int left = 0;
        int right = idx.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(idx.get(mid)==key){
                return val.get(mid);
            }else if(idx.get(mid)>key){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int left = 0;
        int right = idx.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(idx.get(mid)==key){
                idx.remove(mid);
                val.remove(mid);
                break;
            }else if(idx.get(mid)>key){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
