class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,HashMap<Integer,Integer>> dp = new HashMap<>();
        HashMap<Integer,Integer> now = new HashMap<>();
        now.put(nums[0],1);
        now.put(-nums[0],now.getOrDefault(-nums[0],0)+1);
        dp.put(0,now);
        findTargetSumWays(nums,1,dp);
        return dp.get(nums.length-1).getOrDefault(target,0);
    }
    
    public void findTargetSumWays(int[] nums, int idx, HashMap<Integer,HashMap<Integer,Integer>> dp){
        if(idx<nums.length){
            HashMap<Integer,Integer> now = new HashMap<>();
            HashMap<Integer,Integer> before = dp.get(idx-1);
            for(int sum : before.keySet()){
                int tmp = sum+nums[idx];
                now.put(tmp,now.getOrDefault(tmp,0)+before.get(sum));
                tmp = sum-nums[idx];
                now.put(tmp,now.getOrDefault(tmp,0)+before.get(sum));
            }
            dp.put(idx,now);
            findTargetSumWays(nums,idx+1,dp);
        }
    }
}