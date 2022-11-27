class RangeModule {
    List<Range> list;

    public RangeModule() {
        list = new ArrayList<>();
    }
    
    public void addRange(int left, int right) {
        if(list.isEmpty()){
            list.add(0,new Range(left,right));
        }else{
            int idx = search(left,right);
            if(idx<0){
                list.add(idx*-1,new Range(left,right));

            }else{
                if(idx==0&&list.get(idx).left>right){
                    list.add(0,new Range(left,right));
                }else{
                    Range now = list.get(idx);
                    if(now.left>left){
                        now.left =left;
                    }
                    now.right = Math.max(now.right,right);
                    for(int i=idx+1; i<list.size();){
                        Range tmp = list.get(i);
                        if(tmp.left <= now.right){
                            now.right=Math.max(now.right,tmp.right);
                            list.remove(i);
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        // System.out.println("add : "+left+" ~ "+right);
        // print();
    }
    
    public boolean queryRange(int left, int right) {
        if(list.isEmpty()){
            return false;
        }
        int idx = search(left,right);
        // System.out.println("search : "+left+" ~ "+right+" -> "+idx);
        // print();
        if(idx<0){
            return false;
        }else{
            Range now = list.get(idx);
            for(int i=idx; i<list.size(); i++){
                Range tmp = list.get(i);
                if(left < tmp.left){
                    return false;
                }else{
                    left = tmp.right;
                }
                if(left>=right){
                    break;
                }
            }
            return left>=right;
        }
    }
    
    public void removeRange(int left, int right) {
        int idx = search(left,right);
        if(idx<0){
            idx*=-1;
        }
        for(int i=idx; i<list.size(); i++){
            Range tmp = list.get(i);
            if(left>tmp.left && tmp.right>right){
                Range next = new Range(right,tmp.right);
                tmp.right = left;
                list.add(i+1,next);
                break;
            }else if(tmp.left >= left && tmp.right <=right){
                list.remove(tmp);
                i--;
            }else if(left>tmp.left && right>=tmp.right){
                tmp.right = left;
            }else if(right>tmp.left){
                tmp.left = right;
                break;
            }
        }
        // System.out.println("remove : "+left+" ~ "+right);
        // print();
    }
    
    public int search(int left, int right){
        int start = 0;
        int end = list.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            Range now = list.get(mid);
            if(right<=now.left){
                end = mid-1;
            }else if(now.right<=left){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        if(list.size()==start || list.get(start).right<=left || list.get(start).left>=right){
            return -start;
        }
        return start;
    }
    
    public void print(){
        System.out.println("===========");
        for(Range r : list){
            System.out.println(r.left+" ~ "+r.right);
        }
        System.out.println("===========");
    }
}

class Range{
    int left;
    int right;
    public Range(int left, int right){
        this.left = left;
        this.right = right;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */