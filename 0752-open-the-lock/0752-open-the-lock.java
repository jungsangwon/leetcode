class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        int result = 0;
        boolean[] visit = new boolean[10000];
        for(int i=0; i<deadends.length; i++){
            visit[Integer.parseInt(deadends[i])] = true;
        }
        if(visit[0]){
            return -1;
        }
        visit[0] = true;
        int tgt = Integer.parseInt(target);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                int tmp = qu.poll();
                if(tmp == tgt){
                    return result;
                }else{
                    int[] next = getNext(tmp);
                    for(int j=0; j<8; j++){
                        if(!visit[next[j]]){
                            visit[next[j]] = true;
                            qu.add(next[j]);
                        }
                    }
                }
            }
            result++;
        }
        
        return -1;
    }
    
    
    public int[] getNext(int now){
        int[] next = new int[8];
        int tmp = now;
        if(tmp/1000!=9){
            next[0] = now+1000;
        }else{
            next[0] = now%1000;
        }
        
        if(tmp/1000!=0){
            next[1] = now-1000;
        }else{
            next[1] = now+9000;
        }
        tmp %= 1000;
        if(tmp/100!=9){
            next[2] = now+100;
        }else{
            next[2] = (now/1000)*1000+now%100;
        }
        
        if(tmp/100!=0){
            next[3] = now-100;
        }else{
            next[3] = now+900;
        }
        tmp %= 100;
        if(tmp/10!=9){
            next[4] = now+10;
        }else{
            next[4] = (now/100)*100+now%10;
        }
        
        if(tmp/10!=0){
            next[5] = now-10;
        }else{
            next[5] = now+90;
        }
        tmp %= 10;
        if(tmp!=9){
            next[6] = now+1;
        }else{
            next[6] = (now/10)*10;
        }
        
        if(tmp!=0){
            next[7] = now-1;
        }else{
            next[7] = now+9;
        }
        return next;
    }
}