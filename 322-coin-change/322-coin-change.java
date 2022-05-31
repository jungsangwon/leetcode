class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        boolean[] dp = new boolean[amount+1];
        int count = 1;
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0; i<coins.length; i++){
            if(coins[i]<amount){
                qu.add(coins[i]);
            }else if(coins[i]==amount){
                return 1;
            }
        }
        while(!qu.isEmpty()){
            int size = qu.size();
            count++;
            for(int j=0; j<size; j++){
                int now = qu.poll();
                for(int i=0; i<coins.length; i++){
                    int next = now + coins[i];
                    if(next==amount){
                        return count;
                    }else if(next<amount&&!dp[next]){
                        qu.add(next);
                        dp[next] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    
}