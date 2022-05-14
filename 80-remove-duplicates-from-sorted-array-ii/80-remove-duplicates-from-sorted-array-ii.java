class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int idx = 1;
        int tmp = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[idx-1] == nums[i]){
                if(tmp <= 1){
                    nums[idx] = nums[i];
                    tmp++;
                    idx++;
                }else{
                    count++;
                }
            }else{
                nums[idx] = nums[i];
                idx++;
                tmp = 1;
            }
        }
        
        return nums.length - count;
    }
}