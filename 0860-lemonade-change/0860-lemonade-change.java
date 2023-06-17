class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[3];
        for(int bill : bills){
            if(bill ==5){
                count[0]++;
            }else if(bill == 10){
                count[1]++;
                if(count[0]>=1){
                    count[0]--;
                }else{
                    return false;
                }
            }else if(bill == 20){
                count[2]++;
                if(count[1]>=1){
                    if(count[0]>=1){
                        count[1]--;
                        count[0]--;
                    }else{
                        return false;
                    }
                }else if(count[0]>=3){
                    count[0]-=3;
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }
}