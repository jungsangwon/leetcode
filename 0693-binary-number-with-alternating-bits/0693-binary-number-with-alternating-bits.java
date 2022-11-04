class Solution {
    public boolean hasAlternatingBits(int n) {
        int before = -1;
        while(n!=0){
            int tmp = n%2;
            if(tmp==before){
                return false;
            }else{
                before = tmp;
            }
            n/=2;
        }
        return true;
    }
}