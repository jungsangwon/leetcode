class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        int sum  = 1;
        int limit = (int)Math.sqrt(num);
        for(int i=2; i<=limit; i++){
            if(num%i==0){
                sum+=i;
                sum+=(num/i);
                if(sum>num){
                    return false;
                }
            }
        }
        return sum == num;
    }
}