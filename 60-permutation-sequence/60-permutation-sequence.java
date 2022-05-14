class Solution {
    public String getPermutation(int n, int k) {
        if(n == 1){
            return "1";
        }
        StringBuilder result = new StringBuilder();
        int nowDepth = n-1;
        int[] check = new int[n+1];
        int[] depth = new int[n];
        depth[0] = 1;
        depth[1] = 1;
        for(int i=2; i<n; i++){
            depth[i] = depth[i-1] * i;
        }

        while(k>1){
            for(int i=1; i<=n; i++){
                if(k<=depth[nowDepth] && check[i] ==0){
                    result.append(i);
                    nowDepth--;
                    check[i] = 1;
                    break;
                }
                if(check[i] ==0){
                    k -= depth[nowDepth];
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(check[i] == 0){
                result.append(i);
            }
        }
        
        return result.toString();
    }    
}