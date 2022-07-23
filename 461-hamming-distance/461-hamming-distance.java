class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        int num = x^y;
        while(num>0){
            if(num%2==1){
                result++;
            }
            num/=2;
        }
        return result;
    }
}