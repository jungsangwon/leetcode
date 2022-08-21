class Solution {
    public String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        String result = "";
        boolean minus = false;
        if(num<0){
            minus = true;
            num *= -1;
        }
        while(num>0){
            result = (num%7) +result;
            num /= 7;
        }
        if(minus){
            result = "-"+result;
        }
        return result;
    }
}