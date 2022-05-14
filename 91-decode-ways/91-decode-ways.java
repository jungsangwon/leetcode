class Solution {
    public int numDecodings(String s) {
        int result = 0;
        int[] arr = new int[s.length()];
        int[] dp = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = s.charAt(i) - '0';
        }
        if(arr[0]==0){
            return 0;
        }
        if(arr.length>=2){
            if(arr[1] == 0){
                if(arr[0]>2){
                    return 0;
                }else{
                    dp[0] = 0;
                    dp[1] = 1;
                }
            }else{
                int tmp = arr[0]*10 + arr[1];
                if(tmp<=26){
                    dp[0] = 1;
                    dp[1] = 2;
                }else{
                    dp[0] = 1;
                    dp[1] = 1;
                }
            }
        }else{
            return 1;
        }
        for(int i=2; i<=dp.length-1; i++){
            if(arr[i] == 0){
                if(arr[i-1]==0||arr[i-1]>2){
                    return 0;
                }
                dp[i] = dp[i-2];
                if(i+1<=dp.length-1){
                    dp[i+1] = dp[i];
                    i++;
                }
            }else{
                int tmp = arr[i-1]*10 + arr[i];
                if(tmp<=26){
                    dp[i] = dp[i-1] + dp[i-2];
                }else{
                    dp[i] = dp[i-1];
                }
            }
        }
        
        return dp[dp.length-1];
    }
}