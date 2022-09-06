class Solution {
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[c1.length][c2.length];
        for(int i=0; i<c1.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return minDistance(c1,c2,0,0,dp);
    }
    
    public int minDistance(char[] word1, char[] word2, int idx1, int idx2, int[][] dp) {
        int start1 = idx1;
        int start2 = idx2;
        if(idx1==word1.length){
            return word2.length-idx2;
        }else if(idx2==word2.length){
            return word1.length-idx1;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        while(idx1<word1.length && idx2<word2.length && word1[idx1] == word2[idx2]){
            idx1++;
            idx2++;
        }
        if(idx1==word1.length){
            int result = word2.length-idx2;
            dp[start1][start2] = result;
            return result;
        }else if(idx2==word2.length){
            int result = word1.length-idx1;
            dp[start1][start2] = result;
            return result;
        }else{
            int result = Math.min(minDistance(word1,word2,idx1+1,idx2,dp),minDistance(word1,word2,idx1,idx2+1,dp));
            result++;
            dp[start1][start2] = result;
            return result;
        }
    }
}