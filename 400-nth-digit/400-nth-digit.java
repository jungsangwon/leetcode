class Solution {
    public int findNthDigit(int n) {
        if(n<10){
            return n;
        }else{
            n-=9;
            int len = 2;
            long total = 90;
            while(total*len<n){
                n-=total*len;
                total *= 10;
                len++;
            }
            int position = (n%len);
            if(position == 0){
                position = len;
            }
            int count = 1;
            for(int i=position; i<len; i++){
                count *= 10;
            }
            int result = (n-position+1)/(count*len);
            if(position==1){
                return (result%9) + 1;
            }else{
                return result%10;
            }
        }
    }
}