class Solution {
    public int getMoneyAmount(int n) {
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[n+1][n+1];
        getMoneyAmount(1,n,dp);
        // System.out.println("====");
        // for(int i=1; i<=n; i++){
        //     for(int j=i; j<=n; j++){
        //         System.out.println(i+" -> "+j+" = "+dp[i][j]);
        //     }
        // }
        
        return dp[1][n];
    }
    
    public int getMoneyAmount(int left, int right, int[][] dp){
        // System.out.println(left+" ~ "+right);
        if(left==right){
            return 0;
        }else if(dp[left][right]!=0){
            return dp[left][right];
        }else if(right-left==1){
            dp[left][right] = left;
            return left;
        }else if(right-left==2){
            dp[left][right] = left+1;
            return left + 1;
        }
        int result = Integer.MAX_VALUE;
        int root = -1;
        for(int i = right-1; i>left; i--){
            int leftSum = getMoneyAmount(left,i-1,dp);
            int rightSum = getMoneyAmount(i+1,right,dp);
            int sum = i + Math.max(leftSum,rightSum);
            if(sum<result){
                root = i;
                result = sum;
            }
        }
        // System.out.println(left+" -> "+right+" = "+root);
        dp[left][right] = result;
        return result;
    }
}