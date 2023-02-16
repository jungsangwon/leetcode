class Solution {
    public int preimageSizeFZF(int k) {
        long min = 0;
        long max = Long.MAX_VALUE;
        while(min<max){
            long mid = (max)/2+(min)/2;
            long check =getFive(mid);
            if(check==k){
                return 5;
            }else if(check>k){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return 0;   
    }
    
    public long getFive(long k){
        if(k<5){
            return 0;
        }
        return k/5 + getFive(k/5);
    }
}
