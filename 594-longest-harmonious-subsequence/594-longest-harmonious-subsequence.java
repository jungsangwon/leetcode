class Solution {
    public int findLHS(int[] nums) {
        int result = 0;
        int bcount = 0;
        int count = 0;
        int before = Integer.MIN_VALUE;
        int now = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(now==nums[i]){
                count++;
            }else{
                if(before+1==now){
                    result = Math.max(result,bcount+count);
                }
                before = now;
                bcount = count;
                now = nums[i];
                count = 1;
            }
        }
        if(before+1==now){
            result = Math.max(result,bcount+count);
        }
        return result;
    }
}