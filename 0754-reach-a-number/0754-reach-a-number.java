class Solution {
    public int reachNumber(int target) {
        if(target<0){
            target *= -1;
        }
        long start = 1;
        long end = target+1;
        long t = target;
        while(start<end){
            long mid = (start+end)/2;
            long check = mid*(mid+1)/2;
            if(t == check){
                return (int)mid;
            }else if(t<check){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        long tmp = start*(start+1)/2;
        if (t%2==tmp%2){
            return (int)start;
        }else if (start%2==1){
            return (int)start+2;            
        }else{
            return (int)start+1; 
        } 
    }
}