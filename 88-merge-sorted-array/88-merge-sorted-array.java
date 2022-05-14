class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m+n;
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        int[] tmp = new int[m];
        for(int i=0; i<m; i++){
            tmp[i] = nums1[i];
        }
        while(count!=0){
            if(idx1>=m){
                for(int i = idx2; i<n; i++){
                    nums1[idx++] = nums2[i];
                }
                break;
            }else if(idx2>=n){
                for(int i = idx1; i<m; i++){
                    nums1[idx++] = tmp[i];
                }
                break;
            }else if(tmp[idx1]>nums2[idx2]){
                nums1[idx++] = nums2[idx2++];
            }else{
                nums1[idx++] = tmp[idx1++];
            }
            count--;
        }
    }
}