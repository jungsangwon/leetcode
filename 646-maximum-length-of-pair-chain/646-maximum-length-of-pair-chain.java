class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (int[] a, int[] b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        return findLongestChain(pairs,0,new int[pairs.length]);
    }
    
    public int findLongestChain(int[][] pairs, int idx, int[] dp) {
        if(idx==pairs.length-1){
            return 1;
        }else if(idx==pairs.length){
            return 0;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }else{
            int result = 0;
            result = findLongestChain(pairs,idx+1,dp);
            int next = idx+1;
            while(next<pairs.length && pairs[idx][1] >= pairs[next][0]){
                next++;
            }
            result = Math.max(result,findLongestChain(pairs,next,dp)+1);
            dp[idx] = result;
            return result;
        }
    }
}