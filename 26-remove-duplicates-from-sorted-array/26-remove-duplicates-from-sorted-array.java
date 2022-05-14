class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count = 1;
        int now = nums[0];
        int idx = 1;
        for(int i=1; i<nums.length; i++){
            if(now!=nums[i]){
                nums[idx] = nums[i];
                now = nums[i];
                count++;
                idx++;
            }
        }
        return count;
    }
}