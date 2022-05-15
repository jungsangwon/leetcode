class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        int start = 0;
        int now = 0;
        int idx = 0;
        int[] go = new int[gas.length];
        
        
        for(int i=0; i<go.length; i++){
            go[i] = gas[i] - cost[i];
        }
        while(true){
            if(start>=go.length){
                break;
            }else if(start-1 == idx || (start==0 &&idx==go.length-1)){
                now += go[idx];
                if(now>=0){
                    result = start;
                }
                break;
            }
            now += go[idx];
            while(now<0&&start<=idx){
                now -= go[start++];
            }
            idx++;
            if(idx>=go.length){
                idx=0;
            }
            // System.out.println(start+" -> "+idx+" = "+now);
        }
        
        return result;
    }
}