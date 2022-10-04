class MyCircularDeque {
    int[] num;
    int first;
    int last;

    public MyCircularDeque(int k) {
        num = new int[k];
        Arrays.fill(num,-1);
        first = 0;
        last = 0;
    }
    
    public boolean insertFront(int value) {
        if(num[first]==-1){
            num[first]=value;
            return true;
        }else{
            int idx = first - 1;
            if(idx<0){
                idx = num.length-1;
            }
            if(num[idx]==-1){
                num[idx] = value;
                first = idx;
                return true;
            }else{
                return false;
            }
        }
    }
    
    public boolean insertLast(int value) {
        if(num[last]==-1){
            num[last] = value;
            return true;
        }else{
            int idx = last + 1;
            if(idx==num.length){
                idx = 0;
            }
            if(num[idx]==-1){
                num[idx] = value;
                last = idx;
                return true;
            }else{
                return false;
            }
        }
    }
    
    public boolean deleteFront() {
        if(num[first]==-1){
            return false;
        }else{
            num[first] = -1;
            if(last!=first){
                first++;
                if(first==num.length){
                    first = 0;
                }
            }
            return true;
        }
    }
    
    public boolean deleteLast() {
        if(num[last]==-1){
            return false;
        }else{
            num[last]=-1;
            if(last!=first){
                last--;
                if(last==-1){
                    last = num.length-1;
                }
            }
            return true;
        }
    }
    
    public int getFront() {
        return num[first];
    }
    
    public int getRear() {
        return num[last];
    }
    
    public boolean isEmpty() {
        return first == last && num[first]==-1;
    }
    
    public boolean isFull() {
        int idx = last+1;
        if(idx==num.length){
            idx = 0;
        }
        return idx == first; 
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */