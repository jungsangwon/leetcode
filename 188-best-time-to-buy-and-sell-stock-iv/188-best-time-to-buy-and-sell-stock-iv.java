class Solution {
    public int maxProfit(int k, int[] prices) {
        int result = 0;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        int i = 0;
        while(i<prices.length){
            HashMap<Integer,Integer> tmpMap = map.getOrDefault(i,new HashMap<>());
            int idx = prices.length;
            int min = prices[i];
            int max = 0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]>min){
                    while(j+1<prices.length && prices[j]<prices[j+1]){
                        j++;
                    }
                    int tmp = prices[j]-min;
                    if(max<tmp){
                        idx = Math.min(idx,j);
                        tmpMap.put(j,tmp);
                        max = tmp;
                    }
                }else{
                    min = prices[j];
                }
            }
            if(tmpMap.keySet().size()==0){
                break;
            }
            map.put(i,tmpMap);
            i = idx+1;
        }
        int[][] dp = new int[k][prices.length];
        result = maxProfit(k,map,0,0,dp);
        return result;
    }
    
    public int maxProfit(int k, HashMap<Integer,HashMap<Integer,Integer>> map, int before, int count, int[][] dp){
        int result = 0;
        if(!map.containsKey(before)||k<=count){
            return 0;
        }
        if(dp[count][before]!=0){
            return dp[count][before];
        }
        HashMap<Integer,Integer> tmpMap = map.get(before);
        int max = 0;
        for(int i : tmpMap.keySet()){
            result = Math.max(result,tmpMap.get(i)+maxProfit(k,map,i+1,count+1,dp));
        }
        dp[count][before] = result;
        return result;
    }
}