class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] distinctNums = new int[map.keySet().size()];
        int[] count = new int[distinctNums.length];
        int idx=0;
        for(int num : map.keySet()){
            distinctNums[idx] = num;
            count[idx] = map.get(num);
            idx++;
        }
        int result = 0;
        for(int i=0; i<distinctNums.length; i++){
            if(i==distinctNums.length-1 || distinctNums[i]+1!=distinctNums[i+1]){
                result += distinctNums[i] * count[i];
            }else{
                int start = i;
                while(i+1<distinctNums.length && distinctNums[i+1] == distinctNums[i]+1){
                    i++;
                }
                result += deleteAndEarn(distinctNums,count,start,start,i,new int[i-start+1][i-start+1]);
            }
        }
        return result;
    }

    public int deleteAndEarn(int[] nums, int[] count, int base, int start, int end, int[][] dp){
        if(dp[start-base][end-base]!=0){
            return dp[start-base][end-base];
        }
        int result = 0;
        for(int i=start; i<=end; i++){
            int now = 0;
            now += (count[i] * nums[i]);
            int nextIdx = i-1;
            if(i-1>=0 && nums[i]-1==nums[nextIdx]){
                nextIdx--;
            }
            if(nextIdx>=start){
                now += deleteAndEarn(nums,count,base,start,nextIdx,dp);
            }
            nextIdx = i+1;
            if(nextIdx<nums.length && nums[i]+1==nums[nextIdx]){
                nextIdx++;
            }
            if(nextIdx<=end){
                now += deleteAndEarn(nums,count,base,nextIdx,end,dp);
            }
            result = Math.max(result,now);
        }
        dp[start-base][end-base] = result;
        return result;
    }
}