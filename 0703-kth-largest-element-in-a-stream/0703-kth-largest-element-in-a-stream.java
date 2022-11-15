class KthLargest {
    int size;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        pq = new PriorityQueue<>();
        for(int i=0; i<nums.length ; i++){
            pq.add(nums[i]);
        }
        while(pq.size()>size){
            pq.poll();
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>size){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */