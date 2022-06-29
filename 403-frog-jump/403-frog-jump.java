class Solution {
    public boolean canCross(int[] stones) {
        HashMap<String,Boolean> dp = new HashMap<>();
        return canCross(stones,0,0,dp);
    }
    
    public boolean canCross(int[] stones, int now, int k, HashMap<String,Boolean> dp) {
        if(now==stones.length-1){
            return true;
        }
        String key = now+","+k;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        boolean result = false;
        for(int i=now+1; i<stones.length; i++){
            if(stones[i]-stones[now]>k+1){
                break;
            }else if(stones[i]-stones[now]>=k-1){
                result = result || canCross(stones,i,stones[i]-stones[now],dp);
                if(result){
                    break;
                }
            }
        }
        dp.put(key,result);
        return result;
    }
}