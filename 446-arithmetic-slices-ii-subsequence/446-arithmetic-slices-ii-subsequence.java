class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
      int n = nums.length;
        HashMap<Long, Integer> [] dp = new HashMap[n];
        for(int i = 0; i < n; i++){
            dp[i] = new HashMap<>();
        }
        int count = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                long cd = (long)nums[i] - (long)nums[j];
                
                int countInI = dp[i].getOrDefault(cd, 0);
                int countInJ = dp[j].getOrDefault(cd, 0);
                
                count += countInJ;
                dp[i].put(cd, countInI + countInJ + 1);
            }
        }
        return count;
    }
}