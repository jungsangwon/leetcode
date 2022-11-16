class MyHashSet {
    
    List<Integer> list;

    public MyHashSet() {
        this.list = new ArrayList<>();
    }
    
    public void add(int key) {
        int left = 0;
        int right = list.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid)==key){
                left = mid;
                break;
            }else if(list.get(mid)>key){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(left==list.size() || list.get(left)!=key){
            list.add(left,key);
        }
    }
    
    public void remove(int key) {
        int left = 0;
        int right = list.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid)==key){
                list.remove(mid);
                break;
            }else if(list.get(mid)>key){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
    }
    
    public boolean contains(int key) {
        int left = 0;
        int right = list.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid)==key){
                return true;
            }else if(list.get(mid)>key){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */