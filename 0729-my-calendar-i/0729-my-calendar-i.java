class MyCalendar {
    List<Node> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int idx = getIdx(start,end);
        // System.out.println(idx);
        // for(Node n : list){
        //     System.out.println(n.start +" ~ "+n.end);
        // }
        if(idx>=0){
            list.add(idx,new Node(start,end));
            return true;
        }
        return false;
    }
    
    public boolean isDoubleBooking(int start, int end, Node node){
        if(node.start<=start && start<node.end){
            return true;
        }else if(node.start<end && end<node.end){
            return true;
        }else if(start<=node.start && end>=node.end){
            return true;
        }else{
            return false;
        }
    }
    
    public int getIdx(int start, int end){
        int left = 0;
        int right = list.size()-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isDoubleBooking(start,end,list.get(mid))){
                return -1;
            }else if(list.get(mid).end<=start){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}

class Node{
    int start;
    int end;
    public Node(int start, int end){
        this.start = start;
        this.end = end;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */