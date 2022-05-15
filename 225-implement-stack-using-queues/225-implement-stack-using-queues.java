class MyStack {
    Queue<Integer> qu1;
    Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if(!qu1.isEmpty()){
            qu1.add(x);
        }else{
            qu2.add(x);
        }
    }
    
    public int pop() {
        int result = 0;
        if(!qu1.isEmpty()){
            while(qu1.size()>1){
                qu2.add(qu1.poll());
            }
            result = qu1.poll();
        }else{
            while(qu2.size()>1){
                qu1.add(qu2.poll());
            }
            result = qu2.poll();
        }
        return result;
    }
    
    public int top() {
        int num = pop();
        push(num);
        return num;
    }
    
    public boolean empty() {
        return qu1.size()==0&&qu2.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */