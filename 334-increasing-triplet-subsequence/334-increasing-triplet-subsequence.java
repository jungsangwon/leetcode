class Solution {
    public boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        for(int i =nums.length-1;i>=0;i--){
            m1 = Math.max(m1,nums[i]);
            if(m1>nums[i]){
                m2 = Math.max(m2,nums[i]);
                if(m2>nums[i]){
                    return true;
                }
            }
        }
        return false;
    }
}