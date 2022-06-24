class Solution {
    public int lastRemaining(int n) {
        return lastRemaining(n,true);
    }
    public int lastRemaining(int n, boolean left) {
        if(n==1){
            return 1;
        }
        if(!left && n%2==0){
            return lastRemaining(n/2,!left)*2-1;
        }else{
            return lastRemaining(n/2,!left)*2;
        }
    }
}