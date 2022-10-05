class Solution {
    public int countSubstrings(String s) {
        int count = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i][i] = true;
        }
        for(int i=1;i<s.length();i++){
            for(int j=0; j+i<s.length(); j++){
                if(s.charAt(j)==s.charAt(j+i)&&(i==1||dp[j+1][j+i-1])){
                    dp[j][j+i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}