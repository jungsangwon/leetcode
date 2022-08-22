class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        Player[] players = new Player[score.length];
        for(int i=0; i<score.length; i++) {
            players[i] = new Player(score[i],i);
        }
        Arrays.sort(players,(Player a, Player b)->b.score-a.score);
        
        for(int i=0; i<score.length; i++) {
            String tmp = "";
            if(i==0){
                tmp = "Gold Medal";
            }else if(i==1){
                tmp = "Silver Medal";
            }else if(i==2){
                tmp = "Bronze Medal";
            }else{
                tmp = String.valueOf(i+1);
            }
            result[players[i].idx] = tmp;
        }
        return result;
    }
}

class Player{
    int score;
    int idx;
    public Player(int score, int idx){
        this.score = score;
        this.idx = idx;
    }
}