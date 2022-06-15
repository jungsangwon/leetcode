class Solution {
    public int longestStrChain(String[] words) {
        boolean[][] chain = new boolean[words.length][words.length];
        int[] dp = new int[words.length];
        Arrays.fill(dp,-1);
        for(int i=0; i<words.length; i++){
            for(int j = i+1; j<words.length; j++){
                chain[i][j] = isChain(words[i],words[j]);
                chain[j][i] = isChain(words[j],words[i]);
            }
        }
        
        // for(int i=0; i<words.length; i++){
        //     for(int j = 0; j<words.length; j++){
        //         System.out.print(chain[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        int result = 1;
        for(int i=0; i<words.length; i++){
            if(dp[i]==-1){
                result = Math.max(result,getLong(chain,i,dp));
            }
        }
        return result;
    }
    
    public boolean isChain(String a, String b){
        if(a.length()+1 == b.length()){
            int count = 0;
            int idx = 0;
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i)!=b.charAt(idx)){
                    if(count==1){
                        return false;
                    }else{
                        count++;
                        idx++;
                        i--;
                    }
                }else{
                    idx++;
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    public int getLong(boolean[][] chain, int idx, int[] dp){
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int max = 1;
        for(int i=0; i<chain.length; i++){
            if(chain[idx][i]){
                max = Math.max(max,getLong(chain,i,dp)+1);
            }
        }
        dp[idx] = max;
        return max;
    }
}