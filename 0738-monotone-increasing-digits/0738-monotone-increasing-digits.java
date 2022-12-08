class Solution {
    public int monotoneIncreasingDigits(int n) {
        int[] num = new int[String.valueOf(n).length()];
        for(int i=num.length-1; i>=0; i--){
            num[i] = n%10;
            n/=10;
        }
        for(int i=0; i<num.length-1; i++){
            if(i<0){
                break;
            }
            if(num[i]>num[i+1]){
                num[i]--;
                for(int j=i+1; j<num.length; j++){
                    num[j] = 9;
                }
                i-=2;
            }
        }
        int result = 0;
        for(int i=0; i<num.length; i++){
            result *= 10;
            result += num[i];
        }
        return result;
    }
}