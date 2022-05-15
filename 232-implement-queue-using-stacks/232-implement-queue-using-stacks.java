class MyQueue {
    Stack<Integer> enQueue;
    Stack<Integer> deQueue;

    public MyQueue() {
        enQueue = new Stack<>();
        deQueue = new Stack<>();
    }
    
    public void push(int x) {
        enQueue.add(x);
    }
    
    public int pop() {
        if(deQueue.size()!=0){
            return deQueue.pop();
        }else{
            while(!enQueue.isEmpty()){
                deQueue.push(enQueue.pop());
            }
            return deQueue.pop();
        }
    }
    
    public int peek() {
        if(deQueue.size()!=0){
            return deQueue.peek();
        }else{
            while(!enQueue.isEmpty()){
                deQueue.push(enQueue.pop());
            }
            return deQueue.peek();
        }
    }
    
    public boolean empty() {
        return enQueue.isEmpty() && deQueue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */