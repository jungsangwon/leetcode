class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                max = Math.max(count,max);
                count=0;
            }else{
                count++;
            }
        }
        return Math.max(count,max);
    }
}