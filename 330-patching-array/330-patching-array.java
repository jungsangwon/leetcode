class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0;
        long val = 1;
        
        while(val <= n){
            if(i < nums.length && nums[i] <= val){
                val += nums[i++];
            }
            else{
                val += val;
                patches++;
            }
        }
        
         return patches;
    }
}