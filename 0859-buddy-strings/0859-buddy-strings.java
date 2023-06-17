class Solution {
    public boolean buddyStrings(String s, String goal) {
        int check = 0;
        int[][] count = new int[2][26];
        if(s.length() != goal.length()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            count[0][s.charAt(i)-'a']++;
            count[1][goal.charAt(i)-'a']++;
            if(s.charAt(i)!=goal.charAt(i)){
                check++;
            }
        }
        if(check==2){
            for(int i=0; i<26; i++){
                if(count[0][i]!=count[1][i]){
                    return false;
                }
            }
            return true;
        }else if(check == 0){
            for(int i=0; i<26; i++){
                if(count[0][i]>=2){
                    return true;
                }
            }
        }
        return false;
    }
}