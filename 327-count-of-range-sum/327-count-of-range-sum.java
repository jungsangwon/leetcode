class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] numList = new long[nums.length+1];
        long[] tmpList = new long[nums.length+1];
        numList[0] = 0;
        for(int i=1;i<=nums.length;i++){
            numList[i] = numList[i-1] + nums[i-1];
        }
        int[] result = new int[1];
        merge(numList,tmpList,lower,upper,0,numList.length-1,result);
        return result[0];
    }
    
    public void merge(long[] numList,long[] tmpList,int lower,int upper,int left, int right, int[] result){
        if(left==right){
            return;
        }
        int mid = (right + left) / 2;
        merge(numList,tmpList,lower,upper,left,mid,result);
        merge(numList,tmpList,lower,upper,mid+1,right,result);
        int l = left;
        int tl = mid+1;
        int tu = mid+1;
        while(l<=mid){
            while(tl<=right && numList[tl]-numList[l]<lower){
                tl++;
            }
            while(tu<=right && numList[tu]-numList[l]<=upper){
                tu++;
            }
            result[0] += (tu-tl);
            l++;
        }
        int lidx = left;
        int ridx = mid+1;
        int idx = left;
        while(lidx<=mid && ridx <=right){
            if(numList[lidx]<numList[ridx]){
                tmpList[idx++] = numList[lidx++];
            }else{
                tmpList[idx++] = numList[ridx++];
            }
        }
        if(lidx<=mid){
            while(lidx<=mid){
                tmpList[idx++] = numList[lidx++];
            }
        }else{
            while(ridx<=right){
                tmpList[idx++] = numList[ridx++];
            }
        }
        for(int i=left; i<=right; i++){
            numList[left++] = tmpList[i];
        }
    }
}