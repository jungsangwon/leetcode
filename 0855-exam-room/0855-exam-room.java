class ExamRoom {
    List<Integer> list;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        list = new ArrayList<>();
    }
    
    public int seat() {
        if(list.isEmpty()){
            list.add(0);
            // print();
            return 0;
        }else{
            int idx = 0;
            int val = 0;
            int max = list.get(0)-idx;
            for(int i=0; i<list.size()-1; i++){
                int first = list.get(i);
                int second = list.get(i+1);
                int distance = (second-first)/2;
                if(max<distance){
                    idx = i+1;
                    val = (first+second)/2;
                    max = distance;
                }
            }
            int distance = n -1 - list.get(list.size()-1);
            if(distance>max){
                idx = list.size();
                val = n-1;
                max = distance;
            }
            list.add(idx,val);
            // print();
            return val;
        }
    }
    
    public void leave(int p) {
        int left =0;
        int right = list.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid)==p){
                list.remove(mid);
                break;
            }else if(list.get(mid)<p){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        // print();
    }
    
    public void print(){
        for(int t : list){
            System.out.print(t+" ");
        }
        System.out.println("");
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */