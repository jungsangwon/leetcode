class Solution {
    public int addDigits(int num) {
        int result = 0;
        if(num>=10){
            while(num!=0){
                result+=num%10;
                num=num/10;
            }
            return addDigits(result);
        }else{
            return num;
        }
    }
}