class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int sum = 1;
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(idx<i){
                idx = i;
            }
            for(int j=idx;j<nums.length;j++){
                sum*=nums[j];
                idx = j;
                if(sum>=k){
                    break;
                }
            }
            if(idx>=i){
                result += idx - i;
                if(sum<k){
                    result++;
                }
            }
            sum/=nums[i];
            for(int j=idx;j>i;j--){
                sum /= nums[j];
                idx = j;
                if(sum<k){
                    break;
                }
            }
            
        }
        return result;
        
    }
}