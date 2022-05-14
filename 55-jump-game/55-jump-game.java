class Solution {
    public boolean canJump(int[] nums) {
        int max = -1;
        int now = 0;
        int[] flag = new int[nums.length];
        Arrays.fill(flag, -1);
        flag[0] = 0;
        check(nums,flag,0,0,0);
        return flag[nums.length-1] != -1;
    }
    
    public void check(int[] nums, int[] flag, int left, int right, int now){
        int max = 0;
        for(int i=left; i<=right; i++){
            if(max<i+nums[i]){
                max = i+nums[i];
            }
        }
        max = Math.min(nums.length-1,max);
        if(max > right){
            now++;
            for(int i=right+1; i<=max; i++){
                flag[i] = now;
            }
            check(nums,flag,right+1,max,now);
        }
    }
}