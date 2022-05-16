class MedianFinder {
    PriorityQueue<Integer> max = null;
    PriorityQueue<Integer> min = null;
    double sum = 0;
    public MedianFinder() {
        this.max = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.min = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        this.max.add(num);
        this.min.add(this.max.poll());
        
        while(this.max.size() < this.min.size()){
            this.max.add(this.min.poll());
        }
    }
    
    public double findMedian() {
        int n = (this.max.size() + this.min.size());
        if(n%2 == 0){
            return (this.max.peek() + this.min.peek())/2.0;
        }
        else{
            return this.max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */