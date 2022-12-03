class MyCalendarTwo {
    List<Node> list;

    public MyCalendarTwo() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int idx = getIdx(start,end);
        // System.out.println("===="+idx+"==== add : "+start+"~"+end);
        // for(Node n : list){
        //     System.out.println(n.start +" ~ "+n.end+" : "+n.height);
        // }
        if(idx>=0){
            list.add(idx,new Node(start,end));
            return true;
        }else{
            idx *= -1;
            idx--;
            boolean check = true;
            int tmp = idx;
            while(tmp<list.size() && list.get(tmp).start<end){
                if(list.get(tmp).height==2){
                    check = false;
                    break;
                }
                tmp++;
            }
            if(check){
                for(; idx<list.size(); idx++){
                    if(start<end && isDoubleBooking(start,end,list.get(idx))){
                        Node now = list.get(idx);
                        if(now.start==start){
                            if(now.end<=end){
                                now.height++;
                                start = now.end;
                            }else{
                                Node next = new Node(end,now.end);
                                next.height = now.height;
                                list.add(idx+1,next);
                                now.end=end;
                                now.height++;
                                start = next.end;
                            }
                        }else if(now.start>start){
                            Node next = new Node(start,now.start);
                            list.add(idx,next);
                            start = next.end;
                        }else{
                            if(now.end<=end){
                                Node next = new Node(start,now.end);
                                next.height = now.height+1;
                                now.end = start;
                                list.add(idx+1,next);
                                idx++;
                                start = next.end;
                            }else{
                                Node next = new Node(start,end);
                                Node next2 = new Node(end,now.end);
                                next.height = now.height+1;
                                next2.height = now.height;
                                now.end = start;
                                list.add(idx+1,next);
                                list.add(idx+2,next2);
                                idx+=2;
                                start = next.end; 
                            }
                        }
                    }else{
                        break;
                    }
                }
                if(start<end){
                    Node next = new Node(start,end);
                    list.add(idx,next);
                }
                return true;
            }
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
                while(mid-1>=0 && isDoubleBooking(start,end,list.get(mid-1))){
                    mid--;
                }
                return -mid-1;
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
    int height;
    public Node(int start, int end){
        this.start = start;
        this.end = end;
        this.height = 1;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */