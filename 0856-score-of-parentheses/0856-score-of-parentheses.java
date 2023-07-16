class Solution {
    public int idx=0;
    public int scoreOfParentheses(String s) {
        return getScore(s);
    }
    
    public int getScore(String s) {
        if(idx>=s.length()){
            return 0;
        }else if(s.charAt(idx)=='('){
            idx++;
            int score = getScore(s);
            if(score == 0){
                return 1+getScore(s);
            }else{
                return (2*score)+getScore(s);
            }
        }else{
            idx++;
            return  0;
        }
    }
}