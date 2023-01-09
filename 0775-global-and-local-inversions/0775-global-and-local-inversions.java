class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int globalCount = 0;
        int localCount = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                localCount++;
            }
        }
        globalCount = getGlobalCount(nums,0,nums.length-1);
        // System.out.println("localCount = "+localCount);
        // System.out.println("globalCount = "+globalCount);
        if(globalCount == localCount){
            return true;
        }else{
            return false;
        }
    }
    
    public int getGlobalCount(int[] nums, int start, int end){
        if(start == end){
            return 0;
        }else{
            int mid = (start+end)/2;
            int result = getGlobalCount(nums,start,mid);
            result += getGlobalCount(nums,mid+1,end);
            int idx1 = start;
            int idx2 = mid+1;
            int[] tmp = new int[end-start+1];
            int idx = 0;
            int count = 0;
            
            while(idx1<=mid && idx2<=end){
                if(nums[idx1]<nums[idx2]){
                    tmp[idx] = nums[idx1];
                    idx++;
                    idx1++;
                    result += count;
                }else{
                    tmp[idx] = nums[idx2];
                    idx++;
                    idx2++;
                    count++;
                }
            }
            while(idx1<=mid){
                tmp[idx++] = nums[idx1++];
                result += count;
            }
            while(idx2<=end){
                tmp[idx++] = nums[idx2++];
            }
            
            for(int i=0; i<tmp.length; i++){
                nums[i+start] = tmp[i];
            }
            
            return result;
        }
    }
}