class Solution {
    public int splitArray(int[] nums, int m) {
        if(m == nums.length){
            int max = nums[0];
            for(int i=1; i<nums.length; i++){
                max = Math.max(nums[i],max);
            }
            return max;
        }
        List<Integer> sum = new ArrayList<>();
        sum.add(0);
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                sum.add(sum.get(sum.size()-1)+nums[i]);
            }
        }
        int[] sums = new int[sum.size()];
        int idx = 0;
        for(int i : sum){
            sums[idx++] = i;
        }
        m = Math.min(m,sums.length-1);
        return splitArray(sums,0,m-1,new int[sums.length][m]);
    }
    
    public int splitArray(int[] sum, int now, int m, int[][] dp) {
        if(dp[now][m]!=0){
            return dp[now][m];
        }
        if(m==0){
            return sum[sum.length-1] - sum[now];
        }
        int result = Integer.MAX_VALUE;
        for(int i=now+1; i<sum.length-m; i++){
            int max= sum[i] - sum[now];
            int next = splitArray(sum,i,m-1,dp);
            // System.out.println(max + " : "+next);
            max = Math.max(max,next);
            result = Math.min(result,max);
        }
        // System.out.println(result);
        dp[now][m] = result;
        return result;
    }
}