class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length-1];
        while(left<=right){
            int mid = (left+right)/2;
            long count = 0;
            for(int i=0; i<piles.length; i++){
                count+=piles[i]/mid;
                if(piles[i]%mid!=0){
                    count++;
                }
            }
            // System.out.println(mid+" : "+count);
            if(count==h){
                while(mid>0){
                   long check = 0;
                    for(int i=0; i<piles.length; i++){
                        check+=piles[i]/mid;
                        if(piles[i]%mid!=0){
                            check++;
                        }
                    }
                    if(check!=h){
                        mid++;
                        break;
                    }
                    mid--;
                }
                return mid;
            }else if(count<h){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}