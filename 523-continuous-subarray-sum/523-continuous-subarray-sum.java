class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] left = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            left[i+1] = left[i] + nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0&&(i+1<nums.length && nums[i+1]==0)){
                return true;
            }
            for(int j=nums.length;j>i+1;j--){
                int sum = left[j]-left[i];
                if(sum%k==0){
                    return true;
                }else if(sum<k){
                    break;
                }
            }
        }
        return false;
    }
}