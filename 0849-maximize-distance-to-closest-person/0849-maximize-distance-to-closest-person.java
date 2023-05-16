class Solution {
    public int maxDistToClosest(int[] seats) {
        int result = 0;
        int[] left = new int[seats.length];
        int[] right = new int[seats.length];
        
        int now = seats.length;
        for(int i=0; i<seats.length; i++){
            if(seats[i]==1){
                now = 0;
            }else{
                now++;
            }
            left[i] = now;
        }
        now = seats.length;
        for(int i=seats.length-1; i>=0; i--){
            if(seats[i]==1){
                now = 0;
            }else{
                now++;
            }
            right[i] = now;
        }
        for(int i=0; i<seats.length; i++){
            result = Math.max(result,Math.min(left[i],right[i]));
        }
        return result;
    }
}