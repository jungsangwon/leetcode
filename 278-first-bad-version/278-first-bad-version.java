/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left =1;
        long right = n;
        while(left<=right){
            int mid = (int)((left+right)/2);
            if(isBadVersion(mid)){
                right = mid-1;
            }else{
                left =mid+1;
            }
        }
        return (int)left;
    }
}