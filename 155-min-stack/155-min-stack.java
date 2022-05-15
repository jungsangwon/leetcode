class MinStack {
    List<Integer> list;
    PriorityQueue<Integer> qu;
    HashMap<Integer,Integer> count;
    int min;

    public MinStack() {
        list = new ArrayList<>();
        qu = new PriorityQueue<>();
        count = new HashMap<>();
    }
    
    public void push(int val) {
        list.add(val);
        qu.add(val);
        count.put(val,count.getOrDefault(val,0)+1);
    }
    
    public void pop() {
        int tmp = list.get(list.size()-1);
        list.remove(list.size()-1);
        int cnt = count.get(tmp);
        if(cnt==1){
            count.remove(tmp);
        }else{
            count.put(tmp,cnt-1);
        }
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        while(!qu.isEmpty()){
            int tmp = qu.poll();
            if(count.containsKey(tmp)){
                qu.add(tmp);
                return tmp;
            }
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */