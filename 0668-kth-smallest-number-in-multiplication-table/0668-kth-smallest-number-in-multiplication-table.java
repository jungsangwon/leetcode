class Solution {
    public int findKthNumber(int m, int n, int k) {
      int left =1;
      int right=m*n;
      while(left<=right){
          int sum=0;
          int mid =(left+right)/2;
          int j=n;
          for(int i=1;i<=m;i++){
              while(j>=1 && i*j>mid){
                  j--;
              }
              sum+=j;
          }
          if(sum<k){
              left=mid+1;
          }else{
              right=mid-1;
          }
      }
      return left;
    }
}