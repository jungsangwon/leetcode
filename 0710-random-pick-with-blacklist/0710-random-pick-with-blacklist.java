class Solution {
    List<Interval> list;
    Random random;

    public Solution(int n, int[] blacklist) {
        this.list = new ArrayList<>();
        Arrays.sort(blacklist);
        this.random = new Random();
        int start = 0;
        if(blacklist.length==0){
            list.add(new Interval(start,n-1));
        }else{
            for(int i=0; i<blacklist.length; i++){
                if(start<blacklist[i]){
                    list.add(new Interval(start,blacklist[i]-1));
                    start = blacklist[i]+1;
                }else{
                    start++;
                }
            }
            if(start<=n-1){
                list.add(new Interval(start,n-1));
            }
        }
    }
    
    public int pick() {
        return list.get(random.nextInt(list.size())).pick();
    }
}

class Interval{
    int start;
    int end;
    Random random;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
        this.random = new Random();
    }
    
    public int pick(){
        return random.nextInt(end-start+1)+start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */