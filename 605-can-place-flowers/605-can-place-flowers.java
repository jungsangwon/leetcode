class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0; i<flowerbed.length; i++){
            if((i-1<0||flowerbed[i-1]!=1)&& flowerbed[i]!=1){
                if(i+1==flowerbed.length || flowerbed[i+1] !=1){
                    count++;
                    i++;
                }
            }else{
                i++;
            }
        }
        return count>=n;
    }
}