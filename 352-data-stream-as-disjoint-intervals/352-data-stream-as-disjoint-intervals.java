class SummaryRanges {
    PriorityQueue<Integer> pq;

    public SummaryRanges() {
        pq = new PriorityQueue<>();
    }
    
    public void addNum(int val) {
        if(!pq.contains(val)){
            pq.add(val);
        }
    }
    
    public int[][] getIntervals() {
        if(pq.isEmpty()){
            return null;
        }
        PriorityQueue<Integer> tmp = new PriorityQueue<>();
        List<Integer> from = new ArrayList<>();
        List<Integer> to = new ArrayList<>();
        int idx = 0;
        int start = pq.poll();
        tmp.add(start);
        from.add(start);
        to.add(start);
        while(!pq.isEmpty()){
            int now = pq.poll();
            if(to.get(idx)+1==now){
                to.remove(idx);
                to.add(now);
            }else{
                from.add(now);
                to.add(now);
                idx++;
            }
            tmp.add(now);
        }
        while(!tmp.isEmpty()){
            pq.add(tmp.poll());
        }
        int[][] result = new int[from.size()][2];
        for(int i=0; i<from.size(); i++){
            result[i][0] = from.get(i);
            result[i][1] = to.get(i);
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */