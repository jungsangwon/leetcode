class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0;
        while(idx<bits.length-1){
            if(bits[idx]==1){
                idx+=2;
            }else{
                idx++;
            }
        }
        return idx == bits.length-1;
    }
}