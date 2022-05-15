class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp(result,s,0,new ArrayList<>(),dp);
        return result;
    }
    
    public void dp(List<List<String>> result, String s, int idx, List<String> now, boolean[][] dp){
        if(idx>=s.length()){
            result.add(new ArrayList<>(now));
        }else{
            for(int i=idx; i<s.length(); i++){
                boolean check = true;
                if(s.charAt(idx)!=s.charAt(i)||(i-idx>=2 && !dp[idx+1][i-1])){
                    check = false;
                    dp[idx][i] = false;
                }
                if(check){
                    dp[idx][i] = true;
                    now.add(s.substring(idx,i+1));
                    dp(result,s,i+1,now,dp);
                    now.remove(now.size()-1);
                }
            }
        }
    }
    
}