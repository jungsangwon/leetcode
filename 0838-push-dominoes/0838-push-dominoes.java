class Solution {
    public String pushDominoes(String dominoes) {
        int[] countL = new int[dominoes.length()];
        int[] countR = new int[dominoes.length()];
        char[] list = dominoes.toCharArray();
        int now = -1;
        for(int i=0; i<list.length; i++){
            if(list[i]=='R'){
                now=0;
            }else if(list[i]=='L'){
                now = -1;
            }
            if(now>=0){
                countR[i] += now;
                now++;
            }
        }
        
        now = -1;
        for(int i=list.length-1; i>=0; i--){
            if(list[i]=='L'){
                now=0;
            }else if(list[i]=='R'){
                now = -1;
            }
            if(now>=0){
                countL[i] += now;
                now++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.length; i++){
            if(list[i]=='.'){
                if(countR[i]==0 && countL[i]!=0){
                    sb.append("L");
                }else if(countR[i]!=0 && countL[i]==0){
                    sb.append("R");
                }else if(countL[i]>countR[i]){
                    sb.append("R");
                }else if(countL[i]<countR[i]){
                    sb.append("L");
                }else{
                    sb.append(".");
                }
            }else{
                sb.append(list[i]);
            }
        }
        return sb.toString();
    }
}