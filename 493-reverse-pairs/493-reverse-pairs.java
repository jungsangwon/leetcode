class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    
    public int mergeSort(int[] nums, int left, int right){
        if(left>=right){
            return 0;
        }
        int result = 0;
        int mid = (left+right)/2;
        result += mergeSort(nums,left,mid);
        result += mergeSort(nums,mid+1,right);
        result += merge(nums,left,right,mid);
        return result;
    }
    
    public int merge(int[]nums, int start, int end, int mid){
        int n1=mid-start+1;
        int n2=end-mid;
        int left[]=new int[n1];
        int right[]=new int[n2];
        int res=0;
        for(int i=0;i<n1;i++){
            left[i]=nums[start+i];
        }
        for(int j=0;j<n2;j++){
            right[j]=nums[mid+1+j];
        }
        int s=0;
        for(int i=0;i<n1;i++){
           while(s<n2&&left[i]>2*(long)right[s])
               s++;
            res+=s;
        }
        
        int i=0,j=0;
        int k=start;
        while(i<n1&&j<n2)
        {
            if(left[i]<=right[j]){
                nums[k++]=left[i++];
            }else{
               nums[k++]=right[j++];
            }
        }
        while(i<n1) nums[k++]=left[i++];
        while(j<n2) nums[k++]=right[j++];
        return res;
    }
}