class Solution {
    public int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        int result = 0;
        while(num!=0){
            if(num%2==1){
                result+=2;
            }else{
                result++;
            }
            num = num/2;
        }
        result--;
        return result;
    }
}