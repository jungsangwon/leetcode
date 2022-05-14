class Solution {
    public int mySqrt(int x) {
        int right = 46340;
        int left = 0;
        while(right >= left){
            int mid = (right + left) / 2;
            int tmp = mid*mid;
            if(x==tmp){
                return mid;
            }else if(x<tmp){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left-1;
    }
}