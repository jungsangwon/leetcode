class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while(left<=right){
            long mid = (left+right)/2;
            long tmp = mid*mid;
            if(tmp == num){
                return true;
            }else if(tmp<num){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left * left == num;
    }
}