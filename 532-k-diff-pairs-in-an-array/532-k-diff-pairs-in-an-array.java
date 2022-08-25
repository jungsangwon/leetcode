class Solution {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i-1>=0 && nums[i-1] == nums[i]){
                continue;
            }
            for(int j=i+1; j<nums.length; j++){
                int now = nums[j]-nums[i];
                if(now>k){
                    break;
                }else if(now==k){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}