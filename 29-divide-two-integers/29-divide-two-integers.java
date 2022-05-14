class Solution {
    public int divide(int dividend, int divisor) {
        long result = 0;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        boolean plus = true;
        if(dividend<0){
            plus = plus == false;
        }
        if(divisor<0){
            plus = plus == false;
        }
        long check = dvs;
        long count = 1;
        if(dvd<dvs){
            return 0;
        }
        while(dvd>=dvs){
            while(dvd<check){
                check -= dvs;
                count--;
            }
            dvd -= check;
            result += count;
            check += dvs;
            count ++;
        }
        if(!plus){
            result = -result;
        }
        System.out.println(result);
        if(result<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else if(result>=Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }
}