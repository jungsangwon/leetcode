class Solution {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        for(char c : moves.toCharArray()){
            if(c=='U'){
                x++;
            }else if(c=='D'){
                x--;
            }else if(c=='R'){
                y++;
            }else{
                y--;
            }
        }
        return x==0 && y==0;
    }
}