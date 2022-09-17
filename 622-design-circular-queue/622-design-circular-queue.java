class MyCircularQueue {
    int first=0;
    int last=0;
    int[] nums;

    public MyCircularQueue(int k) {
        nums = new int[k];
        Arrays.fill(nums,-1);
    }
    
    public boolean enQueue(int value) {
        if(nums[last]!=-1){
            return false;
        }else{
            nums[last] = value;
            last++;
            if(last == nums.length){
                last = 0;
            }
            return true;
        }
        
    }
    
    public boolean deQueue() {
        if(nums[first]==-1){
            return false;
        }else{
            nums[first] = -1;
            first++;
            if(first == nums.length){
                first = 0;
            }
            return true;
        }
    }
    
    public int Front() {
        return nums[first];
    }
    
    public int Rear() {
        int idx = last-1;
        if(idx==-1){
            idx = nums.length-1;
        }
        return nums[idx];
    }
    
    public boolean isEmpty() {
        return first == last && nums[first] == -1;
    }
    
    public boolean isFull() {
        return first == last && nums[first] != -1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */