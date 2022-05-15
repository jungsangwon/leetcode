class Solution {
    public int missingNumber(int[] nums) {
        int n = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i]<nums.length){
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
                if(nums[i]!=i){
                    i--;
                }
            }
        }
        for(int i=0; i<nums.length; i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}