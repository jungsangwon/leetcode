class Solution {
    int result = 0;
    public int rotatedDigits(int n) {
        for(int i=1; i<10; i++){
            if(i==3 || i==4 || i==7){
                continue;
            }else if(i==0 || i==1 || i==8){
                rotatedDigits(n,i,false);
            }else{
                rotatedDigits(n,i,true);
            }
        }
        return result;
    }
    
    public void rotatedDigits(int n, int now, boolean check){
        if(now > n){
            return;
        }else if(check){
            result++;
        }
        for(int i=0; i<=9; i++){
            int tmp = now*10+i;
            if(i==0 || i==1 || i==8){
                rotatedDigits(n,tmp,check||false);
            }else if(i==2||i==5||i==6||i==9){
                rotatedDigits(n,tmp,check||true);
            }
        }
    }
}