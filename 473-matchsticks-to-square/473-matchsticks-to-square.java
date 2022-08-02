class Solution {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int sum = 0;
        for(int a : matchsticks){
            sum += a;
        }
        if(sum%4!=0){
            return false;
        }
        int len = sum/4;
        return makesquare(matchsticks,len,0,0,new boolean[matchsticks.length]);
    }
    
    public boolean makesquare(int[] matchsticks, int len, int now, int count, boolean[] visit) {
        if(len == now){
            if(count==3){
                return true;
            }else{
                count++;
                now = 0;
            }
        }
        int before = -1;
        for(int i=matchsticks.length-1; i>=0; i--){
            boolean check = false;
            if(visit[i]||matchsticks[i]==before){
                continue;
            }else{
                if(matchsticks[i]<=len-now){
                    visit[i] = true;
                    check = makesquare(matchsticks,len,now+matchsticks[i],count,visit);
                    if(check){
                        return check;
                    }else{
                        visit[i] = false;
                        before = matchsticks[i];
                    }
                }else{
                    break;
                }
            }
        }
        return false;
    }
}