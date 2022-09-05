class Solution {
    public int arrayNesting(int[] nums) {
        int result = 0;
        boolean[] visit = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(!visit[i]){
                int len = getLen(nums,visit,i);
                result = Math.max(len,result);
            }
        }
        return result;
    }
    
    public int getLen(int[] nums, boolean[] visit, int idx){
        int len = 0;
        while(!visit[idx]){
            visit[idx] = true;
            idx = nums[idx];
            len++;
        }
        return len;
    }
}